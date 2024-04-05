package com.sacral.controller;

import com.sacral.model.LoanApplication;
import com.sacral.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/{applicantId}")
    public LoanApplication findByApplicantId(@PathVariable Long applicantId) {
        return loanApplicationService.findByApplicantId(applicantId);
    }

    @GetMapping("/credit-score/{minimumCreditScore}")
    public List<LoanApplication> findByMinimumCreditScore(@PathVariable int minimumCreditScore) {
        return loanApplicationService.findByMinimumCreditScore(minimumCreditScore);
    }

    @GetMapping("/loan-requirements")
    public List<LoanApplication> findByLoanRequirements(@RequestParam double minimumLoanAmount,
                                                       @RequestParam double maximumInterestRate,
                                                       @RequestParam int maximumRepaymentPeriod) {
        return loanApplicationService.findByLoanRequirements(minimumLoanAmount, maximumInterestRate, maximumRepaymentPeriod);
    }

    @GetMapping("/approved")
    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationService.findApprovedApplications();
    }

    @GetMapping("/rejected")
    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationService.findRejectedApplications();
    }
}