package com.perficient.onlineshop.transactionui;

public class TransactionUI {
    private static final long serialVersionUID=1L;
    private Long userid;
    private Long pdid;
    private String tdate;
    private Long id;

    public TransactionUI(Long userid, Long pdid, String tdate) {
        this.userid = userid;
        this.pdid = pdid;
        this.tdate = tdate;
    }

    public TransactionUI(){}

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getPdid() {
        return pdid;
    }

    public void setPdid(Long pdid) {
        this.pdid = pdid;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
