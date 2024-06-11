package com.sacral.service;

import com.sacral.model.LoanApplication;
import com.sacral.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public List<LoanApplication> getLoanApplicationsByStatus(String status) {
        return loanApplicationRepository.findByStatus(status);
    }

    public List<LoanApplication> getLoanApplicationsByLoanProduct(String loanProduct) {
        return loanApplicationRepository.findByLoanProduct(loanProduct);
    }

    public List<LoanApplication> getLoanApplicationsByEligibilityCriteria(String eligibilityCriteria) {
        return loanApplicationRepository.findByEligibilityCriteria(eligibilityCriteria);
    }

    public List<LoanApplication> getLoanApplicationsByDateRange(Date startDate, Date endDate) {
        return loanApplicationRepository.findByApplicationDateBetween(startDate, endDate);
    }

    public List<LoanApplication> getLoanApplicationsByRegulatoryChanges() {
        return loanApplicationRepository.findByRegulatoryChanges();
    }

    public List<LoanApplication> getLoanApplicationsByBusinessProcessChanges() {
        return loanApplicationRepository.findByBusinessProcessChanges();
    }

    public List<LoanApplication> getLoanApplicationsByVersion(int version) {
        return loanApplicationRepository.findByVersion(version);
    }
}