package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AucPaymentRegistered extends AbstractEvent {

    private Long aucId;
    private Long bidId;
    private String paymentResult;
    private Long aucPostId;
    private String paymentGubun;
    private Long auctionedMemId;
    private String beAuctionedDate;
    private String paymentReqYN;
    private Long beAuctionedAmount;
    private String procGUBUN;


    public AucPaymentRegistered(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public String getPaymentResult() {
        return paymentResult;
    }
    public void setPaymentResult(String paymentResult) {
        this.paymentResult = paymentResult;
    }

    public Long getBidId() {
        return bidId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public String getPaymentGubun() {
        return paymentGubun;
    }
    public void setPaymentGubun(String paymentGubun) {
        this.paymentGubun = paymentGubun;
    }

    public Long getAuctionedMemId() {
        return auctionedMemId;
    }
    public void setAuctionedMemId(Long auctionedMemId) {
        this.auctionedMemId = auctionedMemId;
    }

    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }

    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }

    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }
    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }






}