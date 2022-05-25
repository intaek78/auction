package com.example.auction.domain;

import javax.persistence.*;

@Entity
@Table(name="AuctionPost_table")
public class AuctionPost {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long postId;
    private Long aucId2;
    private String title;
    private Long aucPostId;
    private String content;
    private String status;
    private String crtDate;
    private Long aucStartAmount;
    private String payMth;
    private String uptDate;
    private Long buyerId;
    private String procGUBUN;
    private Long sellerId;
    private String beAuctionedDate;
    private Long beAuctionedAmount;
    private String paymentReqYN;
    private String beAuctionedYnAuc;




    @PrePersist
    public void onPrePersist(){
        procGUBUN = "R";
    }

    public Long getPostId() {
        return postId;
    }
    public Long getAucId2() {
        return aucId2;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setAucId2(Long aucId2) {
        this.aucId2 = aucId2;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public String getTitle() {
        return title;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setAucStartAmount(Long aucStartAmount) {
        this.aucStartAmount = aucStartAmount;
    }

    public Long getAucStartAmount() {
        return aucStartAmount;
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
    public void setUptDate(String uptDate) {
        this.uptDate = uptDate;
    }

    public String getUptDate() {
        return uptDate;
    }
    public Long getSellerId() {
        return sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }


    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }


    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }
    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }
    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }

    public String getBeAuctionedYnAuc() {
        return beAuctionedYnAuc;
    }
    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setBeAuctionedYnAuc(String beAuctionedYnAuc) {
        this.beAuctionedYnAuc = beAuctionedYnAuc;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }





}
