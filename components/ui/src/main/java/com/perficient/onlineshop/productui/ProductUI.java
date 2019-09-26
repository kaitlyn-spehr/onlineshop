package com.perficient.onlineshop.productui;

public class ProductUI {
    private static final long serialVersionUID = 1L;

    private String category;
    private String pdname;
    private double pdcost;
    private String pddescp;
    private  int pdquantity;
    private Long id;

    public ProductUI() {
    }

    public ProductUI(String category, String pdname, double pdcost, String pddescp, int pdquantity) {
        this.category = category;
        this.pdname = pdname;
        this.pdcost = pdcost;
        this.pddescp = pddescp;
        this.pdquantity = pdquantity;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public double getPdcost() {
        return pdcost;
    }

    public void setPdcost(double pdcost) {
        this.pdcost = pdcost;
    }

    public String getPddescp() {
        return pddescp;
    }

    public void setPddescp(String pddescp) {
        this.pddescp = pddescp;
    }

    public  int getPdquantity() {
        return pdquantity;
    }

    public  void setPdquantity(int pdquantity) {
        this.pdquantity = pdquantity;
    }

    public void increasePdquantity(int quantity){
        this.pdquantity += quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
