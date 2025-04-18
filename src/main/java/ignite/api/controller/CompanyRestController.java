package ignite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ignite.api.models.User;
import ignite.api.models.requests.CompanyRequest;
import ignite.api.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@AuthenticationPrincipal User user, @RequestBody CompanyRequest req) {
        companyService.register(user, req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
