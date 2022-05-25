package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class Bidden extends AbstractEvent {

    private Long aucId;
    private Long aucPostId;
    private Long bidId;
    private Long bidId2;
    private Long bidMemId;
    private Long bidAmount;
    private String procGUBUN;

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAucPostId() {  return aucPostId;   }
    public void setAucPostId(Long aucPostId) {     this.aucPostId = aucPostId;    }

    public Long getBidId() {
        return bidId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getBidId2() {
        return bidId2;
    }
    public void setBidId2(Long bidId2) {
        this.bidId2 = bidId2;
    }

    public Long getBidAmount() {
        return bidAmount;
    }
    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Long getBidMemId() {
        return bidMemId;
    }
    public void setBidMemId(Long bidMemId) {
        this.bidMemId = bidMemId;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }
}