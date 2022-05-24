package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class BeAuctioned extends AbstractEvent {

    private Long aucId;

    private String status;
    private Long bidId;
    private Long auctionedMemId;
    private Long aucPostId;
    private String beAuctionedDate;
    private String procGUBUN;
    private Long beAuctionedAmount;




    public BeAuctioned(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }
    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public Long getAucPostId() {
        return aucPostId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public Long getAuctionedMemId() {
        return auctionedMemId;
    }
    public void setAuctionedMemId(Long auctionedMemId) {
        this.auctionedMemId = auctionedMemId;
    }
    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }

    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }
    public String getProcGUBUN() {
        return procGUBUN;
    }
    public Long getBidId() {
        return bidId;
    }

}