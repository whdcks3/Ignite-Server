package ignite.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ignite.api.models.User;
import ignite.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername: " + username);
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 사용자입니다."));

        return CustomUserDetails.build(user);
    }
}
