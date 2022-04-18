package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class Bidden extends AbstractEvent {

    private Long aucId;
    private Long aucPostId;
    private Long bidId;
    private Long bidId2;
    private Long bid_mem_id;
    private Long bid_amount;
    private String proc_GUBUN;

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

    public Long getBid_amount() {
        return bid_amount;
    }
    public void setBid_amount(Long bid_amount) {
        this.bid_amount = bid_amount;
    }

    public Long getBid_mem_id() {
        return bid_mem_id;
    }
    public void setBid_mem_id(Long bid_mem_id) {
        this.bid_mem_id = bid_mem_id;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }
}