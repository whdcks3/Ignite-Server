package ignite.api.service;

import org.springframework.stereotype.Service;

import ignite.api.models.Company;
import ignite.api.models.User;
import ignite.api.models.requests.CompanyRequest;
import ignite.api.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void register(User user, CompanyRequest req) {
        Company company = new Company(user, req);
        companyRepository.save(company);
    }
}
