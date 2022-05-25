package com.example.auction.domain;

import com.example.auction.domain.service.AucPaymentRegistered;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name="Payment_table")
public class Payment {

    private Long postId;
    private Long aucId;

    private Long id;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bidId;
    private Long bidId2;
    private String paymentResult;
    private Long bidMemId;
    private Long amount;
    private String crtDate;
    private String beAuctionedYN;
    private String uptDate;
    private String paymentGubun;
    private String beAuctionedDate;
    private String paymentReqYN;
    private String procGUBUN;
    private String postTitle;
    private String postGubun;
    private Long seller;
    private Long buyer;


    @PostPersist
    public void onPostPersist(){

        AucPaymentRegistered aucPaymentRegistered = new AucPaymentRegistered();
        BeanUtils.copyProperties(this, aucPaymentRegistered);
        aucPaymentRegistered.publishAfterCommit();

        AucPaymentRegistered aucPaymentRegistered2 = new AucPaymentRegistered();
        BeanUtils.copyProperties(this, aucPaymentRegistered2);
        aucPaymentRegistered2.publishAfterCommit();

    }


    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public String getPaymentResult() {
        return paymentResult;
    }
    public void setPaymentResult(String paymentResult) {
        this.paymentResult = paymentResult;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getBidId2() {
        return bidId2;
    }
    public void setBidId2(Long bidId2) {
        this.bidId2 = bidId2;
    }

    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
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

    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
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

    public String getPostTitle() {
        return postTitle;
    }
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getBeAuctionedYN() {
        return beAuctionedYN;
    }
    public void setBeAuctionedYN(String beAuctionedYN) {
        this.beAuctionedYN = beAuctionedYN;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }

    public Long getSeller() {
        return seller;
    }
    public void setSeller(Long seller) {
        this.seller = seller;
    }

    public Long getBuyer() {
        return buyer;
    }
    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    public String getPostGubun() {
        return postGubun;
    }
    public void setPostGubun(String postGubun) {
        this.postGubun = postGubun;
    }

    public String getPaymentGubun() {
        return paymentGubun;
    }
    public void setPaymentGubun(String paymentGubun) {
        this.paymentGubun = paymentGubun;
    }








}
