package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AuctionCompleted extends AbstractEvent {

    private Long aucId;
    private String procGUBUN;
    private Long aucPostId;
    private Long auctionedMemId;
    private Long buyerId;
    private String status;
    private Long beAuctionedAmount;
    private Long sellerId;
    private String beAuctionedDate;


    public AuctionCompleted(){
        super();
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public Long getAucId() {
        return aucId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public Long getAuctionedMemId() {
        return auctionedMemId;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setAuctionedMemId(Long auctionedMemId) {
        this.auctionedMemId = auctionedMemId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }
    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }
    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
}