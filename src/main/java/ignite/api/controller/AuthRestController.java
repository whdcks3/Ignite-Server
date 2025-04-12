package ignite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ignite.api.models.requests.RegisterRequest;
import ignite.api.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        userService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
