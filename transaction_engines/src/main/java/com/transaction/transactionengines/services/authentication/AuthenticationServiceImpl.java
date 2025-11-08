package com.transaction.transactionengines.services.authentication;

import com.transaction.transactionengines.dto.RegisterRequest;
import com.transaction.transactionengines.dto.ChannelUserDto;
import com.transaction.transactionengines.entity.ChannelUsers;
import com.transaction.transactionengines.repository.ChannelUsersRepository;
import com.transaction.transactionengines.services.Thresholds.ThresholdsProfilesService;
import com.transaction.transactionengines.utils.IdGenerator;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final ChannelUsersRepository channelUsersRepository;
    private final IdGenerator idGenerator;
    private final ThresholdsProfilesService thresholdsProfilesService;
    @Override
    public ChannelUserDto createCustomer(RegisterRequest registerRequest) {
        ChannelUsers channelUser = new ChannelUsers();
        channelUser.setUserId(idGenerator.generateUserId());
        channelUser.setThresholdsProfiles(thresholdsProfilesService.getDefalutThresholds());
        channelUser.setUser_name(registerRequest.getUser_name());
        channelUser.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
        channelUser.setTxn_pin(registerRequest.getTxn_pin());
        channelUser.setInvalid_pin_count(registerRequest.getInvalid_pin_count());
        channelUser.setInvalid_password_count(registerRequest.getInvalid_password_count());
        channelUser.setCategory_code(registerRequest.getCategory_code());
        channelUser.setUser_type(registerRequest.getUser_type());
        channelUser.setFirst_name(registerRequest.getFirst_name());
        channelUser.setLast_name(registerRequest.getLast_name());
        channelUser.setMsisdn(registerRequest.getMsisdn());
        channelUser.setModified_on(registerRequest.getModified_on());
        channelUser.setEmailId(registerRequest.getEmailId());
        ChannelUsers createdChannelUser = channelUsersRepository.save(channelUser);
        ChannelUserDto channelUserDto = new ChannelUserDto();
        channelUserDto.setUser_id(createdChannelUser.getUserId());
        channelUserDto.setUser_name(createdChannelUser.getUser_name());
        channelUserDto.setEmailId(createdChannelUser.getEmailId());


        return channelUserDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return channelUsersRepository.findByEmailId(email).isPresent();
    }
}
