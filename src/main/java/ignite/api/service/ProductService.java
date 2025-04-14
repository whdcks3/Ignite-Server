package ignite.api.service;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import ignite.api.models.Company;
import ignite.api.models.Product;
import ignite.api.models.User;
import ignite.api.models.requests.ProductRequest;
import ignite.api.repository.CompanyRepository;
import ignite.api.repository.ProductRepository;
import ignite.api.repository.ProductScheduleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;
    private final ProductScheduleRepository productScheduleRepository;

    public void createProduct(User user, Long companyId, ProductRequest req) {
        Company company = companyRepository.findById(companyId).orElseThrow();
        Product product = new Product(company, req);
        productRepository.save(product);
    }
}
