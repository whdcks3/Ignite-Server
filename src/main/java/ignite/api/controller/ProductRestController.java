package ignite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ignite.api.models.User;
import ignite.api.models.requests.ProductRequest;
import ignite.api.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @PostMapping("/create/{companyId}")
    public ResponseEntity<?> createProduct(@AuthenticationPrincipal User user,
            @PathVariable("companyId") Long productId, @RequestBody ProductRequest req) {
        productService.createProduct(user, productId, req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
