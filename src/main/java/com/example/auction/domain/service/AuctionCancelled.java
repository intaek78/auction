package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AuctionCancelled extends AbstractEvent {

    private Long aucId;
    private Long aucPostId;
    private String status;
    private Long auctioned_mem_id;
    private String proc_GUBUN;

    private Long sellerId;

    public AuctionCancelled(){
        super();
    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAuctioned_mem_id() {
        return auctioned_mem_id;
    }
    public void setAuctioned_mem_id(Long auctioned_mem_id) {
        this.auctioned_mem_id = auctioned_mem_id;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}