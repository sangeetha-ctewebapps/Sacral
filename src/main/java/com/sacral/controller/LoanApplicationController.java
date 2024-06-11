package com.sacral.controller;

import com.sacral.model.LoanApplication;
import com.sacral.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/status/{status}")
    public List<LoanApplication> getLoanApplicationsByStatus(@PathVariable String status) {
        return loanApplicationService.getLoanApplicationsByStatus(status);
    }

    @GetMapping("/loan-product/{loanProduct}")
    public List<LoanApplication> getLoanApplicationsByLoanProduct(@PathVariable String loanProduct) {
        return loanApplicationService.getLoanApplicationsByLoanProduct(loanProduct);
    }

    @GetMapping("/eligibility-criteria/{eligibilityCriteria}")
    public List<LoanApplication> getLoanApplicationsByEligibilityCriteria(@PathVariable String eligibilityCriteria) {
        return loanApplicationService.getLoanApplicationsByEligibilityCriteria(eligibilityCriteria);
    }

    @GetMapping("/date-range")
    public List<LoanApplication> getLoanApplicationsByDateRange(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        return loanApplicationService.getLoanApplicationsByDateRange(startDate, endDate);
    }

    @GetMapping("/regulatory-changes")
    public List<LoanApplication> getLoanApplicationsByRegulatoryChanges() {
        return loanApplicationService.getLoanApplicationsByRegulatoryChanges();
    }

    @GetMapping("/business-process-changes")
    public List<LoanApplication> getLoanApplicationsByBusinessProcessChanges() {
        return loanApplicationService.getLoanApplicationsByBusinessProcessChanges();
    }

    @GetMapping("/version/{version}")
    public List<LoanApplication> getLoanApplicationsByVersion(@PathVariable int version) {
        return loanApplicationService.getLoanApplicationsByVersion(version);
    }
}