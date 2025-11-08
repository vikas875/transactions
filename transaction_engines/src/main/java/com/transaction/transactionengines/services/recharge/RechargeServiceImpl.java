package com.transaction.transactionengines.services.recharge;
import com.transaction.transactionengines.dto.RechargeRequest;
import com.transaction.transactionengines.entity.*;
import com.transaction.transactionengines.enums.SubscriberStatus;
import com.transaction.transactionengines.repository.SubscriberWalletRepository;
import com.transaction.transactionengines.repository.TransactionHeaderRepository;
import com.transaction.transactionengines.repository.WalletRepository;
import com.transaction.transactionengines.utils.IdGenerator;
import com.transaction.transactionengines.validation.GlobalValidation;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class RechargeServiceImpl implements RechargeService{

    private final GlobalValidation globalValidation;
    private final SubscriberWalletRepository subscriberWalletRepository;
    private final IdGenerator idGenerator;
    private final TransactionHeaderRepository transactionHeaderRepository;
    private final WalletRepository walletRepository;

    @Transactional
    @Override
    public TransactionHeader processRecharge(RechargeRequest request) {

        Subscribers subscribers = globalValidation.validatePayer(request.getPayerUserId(), SubscriberStatus.Active);

        ChannelUsers channelUsers = globalValidation.validatePayee(request.getPayeeUserId(),"Y");

        ServiceTypes serviceTypes = globalValidation.isValidService(request.getService(),"Y");

        ITNProductProfile itnProductProfile = globalValidation.validateProduct(request.getProductId(),"Y");
        globalValidation.validateThresholds(subscribers,request.getAmount());


        SubscriberWallet subscriberWallet = globalValidation.isValidAmount(request.getAmount(),request.getPayerUserId());
        Wallet channelWallet = walletRepository.findByUserId(request.getPayeeUserId()).get();

      TransactionHeader transactionHeader = new TransactionHeader();
      transactionHeader.setTransferId(idGenerator.generateTransferId());
      transactionHeader.setPayerUserId(subscribers.getSubscriberId());
      transactionHeader.setPayeeUserId(channelUsers.getUserId());
      transactionHeader.setTransferOn(LocalDateTime.now());
      transactionHeader.setRequestedValue(subscriberWallet.getBalance());
      transactionHeader.setTransferStatus("success");
      transactionHeader.setModified_on(ZonedDateTime.now());
      transactionHeader.setProduct_type(itnProductProfile.getProductId().getProductType());
      transactionHeader.setService_provider(itnProductProfile.getProductId().getServiceProvider());
      transactionHeader.setRecharge_type(itnProductProfile.getProductId().getRechargeType());
      transactionHeader.setService_type(serviceTypes.getServiceType());
      transactionHeader.setProduct_id(itnProductProfile.getProductIdValue());
      transactionHeaderRepository.save(transactionHeader);

        debitAmount(subscriberWallet,request,transactionHeader);
        creditAmount(channelWallet,request,transactionHeader);

      return transactionHeader;
    }

    public void debitAmount(SubscriberWallet subscriberWallet, RechargeRequest request,TransactionHeader transactionHeader){
        subscriberWallet.setPrevBalance(subscriberWallet.getBalance());
        subscriberWallet.setBalance((long)((subscriberWallet.getBalance()/Math.pow(10,6) - request.getAmount())*Math.pow(10,6)));
        subscriberWallet.setLastTransationType(request.getService());
        subscriberWallet.setLastTransationId(transactionHeader.getTransferId());
        subscriberWallet.setStatus(transactionHeader.getTransferStatus());
        subscriberWallet.setLastTransationOn(transactionHeader.getTransferOn());
        subscriberWalletRepository.save(subscriberWallet);
    }

    public void creditAmount(Wallet channelWallet, RechargeRequest request, TransactionHeader transactionHeader){
        channelWallet.setPrevBalance(channelWallet.getBalance());
        channelWallet.setBalance((long)((channelWallet.getBalance()/Math.pow(10,6) + request.getAmount())*Math.pow(10,6)));
        channelWallet.setLastTransationType(request.getService());
        channelWallet.setLastTransationId(transactionHeader.getTransferId());
        channelWallet.setStatus(transactionHeader.getTransferStatus());
        channelWallet.setLastTransationOn(transactionHeader.getTransferOn());
        walletRepository.save(channelWallet);
    }
}
