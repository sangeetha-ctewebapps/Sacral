
package com.sacral.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_application")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "loan_product")
    private String loanProduct;

    @Column(name = "eligibility_criteria")
    private String eligibilityCriteria;

    @Column(name = "application_date")
    private Date applicationDate;

    @Column(name = "regulatory_changes")
    private boolean regulatoryChanges;

    @Column(name = "business_process_changes")
    private boolean businessProcessChanges;

    @Column(name = "version")
    private int version;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(String loanProduct) {
        this.loanProduct = loanProduct;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public boolean isRegulatoryChanges() {
        return regulatoryChanges;
    }

    public void setRegulatoryChanges(boolean regulatoryChanges) {
        this.regulatoryChanges = regulatoryChanges;
    }

    public boolean isBusinessProcessChanges() {
        return businessProcessChanges;
    }

    public void setBusinessProcessChanges(boolean businessProcessChanges) {
        this.businessProcessChanges = businessProcessChanges;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
