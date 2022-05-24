package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class BeAuctionRegistered extends AbstractEvent {

    private Long aucId;
    private String procGUBUN;
    private Long aucPostId;
    private String status;
    private Long beAuctionedAmount;
    private String beAuctionedDate;
    private Long auctionedMemId;


    public BeAuctionRegistered(){
        super();
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }
    public Long getAucId() {
        return aucId;
    }
    public Long getAucPostId() {
        return aucPostId;
    }
    public String getStatus() {
        return status;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAuctionedMemId(Long auctionedMemId) {
        this.auctionedMemId = auctionedMemId;
    }
    public Long getAuctionedMemId() {
        return auctionedMemId;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }

    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public String getProcGUBUN() {
        return procGUBUN;
    }
    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }
    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }



}