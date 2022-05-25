package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AucRegisterd extends AbstractEvent {

    private Long aucId;

    private Long aucId2;
    private Long aucPostId;
    private String title;
    private String content;
    private String status;
    private Long aucStartAmount;
    private String payMth;
    private String crtDate;
    private String uptDate;
    private Long buyerId;
    private String completeYn;

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getAucId2() {
        return aucId2;
    }
    public void setAucId2(Long aucId2) {
        this.aucId2 = aucId2;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAucStartAmount() {
        return aucStartAmount;
    }
    public void setAucStartAmount(Long aucStartAmount) {
        this.aucStartAmount = aucStartAmount;
    }

    public String getPayMth() {
        return payMth;
    }
    public void setPayMth(String payMth) {
        this.payMth = payMth;
    }

    public String getCrtDate() {
        return crtDate;
    }
    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getUptDate() {
        return uptDate;
    }
    public void setUptDate(String uptDate) {
        this.uptDate = uptDate;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getCompleteYn() {
        return completeYn;
    }
    public void setCompleteYn(String completeYn) {
        this.completeYn = completeYn;
    }

}