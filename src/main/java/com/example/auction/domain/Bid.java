package com.example.auction.domain;

import com.example.auction.domain.service.Bidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Slf4j
@Entity
@Table(name="Bid_table")
public class Bid{

    private Long aucPostId;
    private Long aucId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bidId;
    private Long bidId2;
    private String status;
    private Long bidMemId;
    private Long bidAmount;
    private Long sellerId;
    private String crtDate;
    private String title;
    private String uptDate;
    private String beAuctionedDate;
    private String procGUBUN;
    private String beAuctionedYN;
    private String paymentReqYN;


    @PostPersist
    public void onPostPersist(){
        Bidden bidden = new Bidden();
        BeanUtils.copyProperties(this, bidden);
        bidden.publishAfterCommit();

        Bidden bidden2 = new Bidden();
        BeanUtils.copyProperties(this, bidden2);
        bidden2.publishAfterCommit();

    }

    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBidId2() {
        return bidId2;
    }
    public void setBidId2(Long bidId2) {
        this.bidId2 = bidId2;
    }

    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public Long getBidId() {
        return bidId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getBidMemId() {
        return bidMemId;
    }
    public void setBidMemId(Long bidMemId) {
        this.bidMemId = bidMemId;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBidAmount() {
        return bidAmount;
    }
    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public String getBeAuctionedYN() {
        return beAuctionedYN;
    }
    public void setBeAuctionedYN(String beAuctionedYN) {
        this.beAuctionedYN = beAuctionedYN;
    }














}
