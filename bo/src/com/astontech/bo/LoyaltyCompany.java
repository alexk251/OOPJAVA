package com.astontech.bo;

public class LoyaltyCompany extends BaseBO{
    private int LoyaltyCompanyId;
    private int EntityTypeId;
    private String CompanyName;

    public LoyaltyCompany() {

    }

    public LoyaltyCompany(String companyName) {
        this.setCompanyName(companyName);
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
}
