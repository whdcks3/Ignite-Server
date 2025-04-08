package ignite.api.service;

import org.springframework.stereotype.Service;

import ignite.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
