package ignite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ignite.api.models.User;
import ignite.api.models.requests.PurchaseRequest;
import ignite.api.service.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/create")
    public ResponseEntity<?> purchase(@AuthenticationPrincipal User user,
            @RequestBody PurchaseRequest req) {
        purchaseService.createPurchase(user.getId(), null, req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
