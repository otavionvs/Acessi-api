package Acessi.com.Acessi.model.service;

import Acessi.com.Acessi.model.entity.Company;
import Acessi.com.Acessi.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepository companyRepository;

    public Company save(Company entity) {
        return companyRepository.save(entity);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Integer integer) {
        return companyRepository.findById(integer);
    }
}
