
package com.sacral.repository;

import com.sacral.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    // Method to retrieve loan applications by status
    List<LoanApplication> findByStatus(String status);

    // Method to retrieve loan applications by loan product
    List<LoanApplication> findByLoanProduct(String loanProduct);

    // Method to retrieve loan applications by eligibility criteria
    List<LoanApplication> findByEligibilityCriteria(String eligibilityCriteria);

    // Method to retrieve loan applications by date range
    List<LoanApplication> findByApplicationDateBetween(Date startDate, Date endDate);

    // Method to retrieve loan applications by regulatory changes
    @Query("SELECT la FROM LoanApplication la WHERE la.regulatoryChanges = true")
    List<LoanApplication> findByRegulatoryChanges();

    // Method to retrieve loan applications by business process changes
    @Query("SELECT la FROM LoanApplication la WHERE la.businessProcessChanges = true")
    List<LoanApplication> findByBusinessProcessChanges();

    // Method to retrieve loan applications by version
    List<LoanApplication> findByVersion(int version);
}
