package com.example.jobapplication.company.impl;

import com.example.jobapplication.company.Company;
import com.example.jobapplication.company.CompanyRepository;
import com.example.jobapplication.company.CompanyService;
import com.example.jobapplication.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            company.setDescription(companyToUpdate.getDescription());
            company.setName(companyToUpdate.getName());
            company.setJobs(companyToUpdate.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
