package ignite.api.controller;

import org.springframework.web.bind.annotation.RestController;

import ignite.api.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
}
