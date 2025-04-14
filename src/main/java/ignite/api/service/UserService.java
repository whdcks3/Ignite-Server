package ignite.api.service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import ignite.api.models.User;
import ignite.api.models.requests.RegisterRequest;
import ignite.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new ValidationException("이미 사용중인 이메일입니다.");
        }
        if (userRepository.existsByPhone(req.getPhone())) {
            throw new ValidationException("이미 사용중인 번호입니다.");
        }
        User user = new User(req);

        userRepository.save(user);
    }

}
