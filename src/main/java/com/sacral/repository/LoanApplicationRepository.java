
package com.sacral.repository;

import com.sacral.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    @Query("SELECT la FROM LoanApplication la WHERE la.applicantId = ?1")
    LoanApplication findByApplicantId(Long applicantId);

    @Query("SELECT la FROM LoanApplication la WHERE la.creditScore >= ?1")
    List<LoanApplication> findByMinimumCreditScore(int minimumCreditScore);

    @Query("SELECT la FROM LoanApplication la WHERE la.loanAmount >= ?1 AND la.interestRate <= ?2 AND la.repaymentPeriod <= ?3")
    List<LoanApplication> findByLoanRequirements(double minimumLoanAmount, double maximumInterestRate, int maximumRepaymentPeriod);

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'APPROVED'")
    List<LoanApplication> findApprovedApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'REJECTED'")
    List<LoanApplication> findRejectedApplications();
}
