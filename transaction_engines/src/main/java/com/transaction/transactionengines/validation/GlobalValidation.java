package com.transaction.transactionengines.validation;

import com.transaction.transactionengines.entity.*;
import com.transaction.transactionengines.enums.SubscriberStatus;
import com.transaction.transactionengines.exceptions.*;
import com.transaction.transactionengines.repository.*;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class GlobalValidation {

    private final ServiceTypesRepository serviceTypesRepository;
    private final SubscriberRepository subscriberRepository;
    private final ChannelUsersRepository channelUsersRepository;
    private final ITNProductProfileRepository itnProductProfileRepository;
    private final SubscriberWalletRepository subscriberWalletRepository;
    private final ThresholdsProfileDetailsRepository thresholdsProfileDetailsRepository;
    private final TransactionHeaderRepository transactionHeaderRepository;


    public ServiceTypes isValidService(String serviceName,String status) {

       ServiceTypes serviceTypes  = serviceTypesRepository.findByServiceNameAndStatus(serviceName,status)
                .orElseThrow(() -> new InvalidServiceException("Invalid Service Types"));
       return serviceTypes;
    }

    public Subscribers validatePayer(String payerUserId, SubscriberStatus status){
        Subscribers subscribers = subscriberRepository.findBySubscriberIdAndStatus(payerUserId,status)
                .orElseThrow(() -> new InvalidSubscriberException("Invalid Payer"));
        return subscribers;
    }

    public ChannelUsers validatePayee(String payeeUserId, String status){
        ChannelUsers channelUsers = channelUsersRepository.findByUserIdAndStatus(payeeUserId,status)
                .orElseThrow(() -> new InvalidChannelUserException("Invalid Payee"));
        return channelUsers;
    }

    public ITNProductProfile validateProduct(String productId,String status){

         ITNProductProfile itnProductProfile = itnProductProfileRepository.findByProductIdValueAndStatus(productId,status)
                 .orElseThrow(() -> new InvalidProductException("Invalid Product Id"));
         System.out.println("modified on" + itnProductProfile.getModifiedOn());
         return itnProductProfile;
    }

    public SubscriberWallet isValidAmount(double amount, String subscriberId) {
        SubscriberWallet subscriberWallet = subscriberWalletRepository.findBySubscriberId(subscriberId)
                .orElseThrow(() -> new InvalidAmountException("Payer Wallet not found"));

        long storedBalance = subscriberWallet.getBalance();
        double currentBalance = storedBalance/Math.pow(10,6);
        if(amount <= 0){
            throw new InvalidAmountException("Invalid amount: must be greater than zero");
        }
        if (currentBalance - amount < 0){
            throw new InvalidAmountException("Insufficient balance for this transaction");
        }

        return subscriberWallet;
    }

    public void validateThresholds(Subscribers subscribers,Double amount ){

          ThresholdsProfiles subscriberThresholdsProfiles = subscribers.getThresholdsProfiles();
        long dailyPayerAmountLimit = thresholdsProfileDetailsRepository.findByThresholdsProfilesAndGroupId(subscriberThresholdsProfiles.getThresProfileId(),"1");
        long weeklyPayerAmountLimit = thresholdsProfileDetailsRepository.findByThresholdsProfilesAndGroupId(subscriberThresholdsProfiles.getThresProfileId(),"2");
        long monthlyPayerAmountLimit = thresholdsProfileDetailsRepository.findByThresholdsProfilesAndGroupId(subscriberThresholdsProfiles.getThresProfileId(),"3");

        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);


        long transactionDailyAmount = transactionHeaderRepository.getDailyTotal(subscribers.getSubscriberId());
        long transactionWeeklyAmount = transactionHeaderRepository.getWeeklyTotal(subscribers.getSubscriberId(),sevenDaysAgo);
        long transactionMonthlyAmount = transactionHeaderRepository.getMonthlyTotal(subscribers.getSubscriberId());

        if(transactionDailyAmount + (long) (amount*Math.pow(10,6)) > dailyPayerAmountLimit){
            throw new InvalidAmountException("Transaction exceeds daily limit!");
        }

        if(transactionWeeklyAmount + (long) (amount*Math.pow(10,6)) > weeklyPayerAmountLimit){
            throw new InvalidAmountException("Transaction exceeds weekly limit!");
        }

        if(transactionMonthlyAmount + (long) (amount*Math.pow(10,6)) > monthlyPayerAmountLimit){
            throw new InvalidAmountException("Transaction exceeds monthly limit!");
        }




    }

}

