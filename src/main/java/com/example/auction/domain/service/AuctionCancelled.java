package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AuctionCancelled extends AbstractEvent {

    private Long aucId;
    private Long aucPostId;
    private Long sellerId;
    private String status;
    private String procGUBUN;


    public AuctionCancelled(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }






}