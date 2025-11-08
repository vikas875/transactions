package com.transaction.transactionengines.services.jwt;

import com.transaction.transactionengines.repository.ChannelUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final ChannelUsersRepository channelUsersRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> channelUsersRepository.findByEmailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Warning, User Not Found !"));
    }
}
