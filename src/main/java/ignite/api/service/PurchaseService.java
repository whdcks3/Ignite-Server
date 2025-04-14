package ignite.api.service;

import org.springframework.stereotype.Service;

import ignite.api.models.Product;
import ignite.api.models.Purchase;
import ignite.api.models.User;
import ignite.api.models.requests.PurchaseRequest;
import ignite.api.repository.ProductRepository;
import ignite.api.repository.PurchaseRepository;
import ignite.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void createPurchase(User user, Long productId, PurchaseRequest req) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        Purchase purchase = new Purchase(user, product, req);
        purchaseRepository.save(purchase);

    }
}
