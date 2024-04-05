package com.sacral.service;

import com.sacral.model.LoanApplication;
import com.sacral.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public LoanApplication findByApplicantId(Long applicantId) {
        return loanApplicationRepository.findByApplicantId(applicantId);
    }

    public List<LoanApplication> findByMinimumCreditScore(int minimumCreditScore) {
        return loanApplicationRepository.findByMinimumCreditScore(minimumCreditScore);
    }

    public List<LoanApplication> findByLoanRequirements(double minimumLoanAmount, double maximumInterestRate, int maximumRepaymentPeriod) {
        return loanApplicationRepository.findByLoanRequirements(minimumLoanAmount, maximumInterestRate, maximumRepaymentPeriod);
    }

    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationRepository.findApprovedApplications();
    }

    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationRepository.findRejectedApplications();
    }
}