package com.example.auction.domain;

import com.example.auction.domain.service.AucPaymentRegistered;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name="AucPayment_table")
public class AucPayment {

    private Long aucId;
    private Long aucPostId;
    private Long bidMemId;
    private String crtDate;
    private String beAuctionedDate;
    private String paymentReqYN;
    private String title;
    private Long sellerId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bidId;
    private Long bidId2;
    private Long bidAmount;
    private String uptDate;
    private String beAuctionedYN;
    private String procGUBUN;
    private String paymentGubun;
    private String paymentResult;



    @PostPersist
    public void onPostPersist(){

        AucPaymentRegistered aucPaymentRegistered = new AucPaymentRegistered();
        BeanUtils.copyProperties(this, aucPaymentRegistered);
        aucPaymentRegistered.publishAfterCommit();

    }



    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }
    public Long getAucId() {
        return aucId;
    }

    public Long getBidId2() {
        return bidId2;
    }
    public Long getAucPostId() {
        return aucPostId;
    }
    public void setBidId2(Long bidId2) {
        this.bidId2 = bidId2;
    }
    public void setBidMemId(Long bidMemId) {
        this.bidMemId = bidMemId;
    }
    public Long getBidId() {
        return bidId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getBidMemId() {
        return bidMemId;
    }

    public String getCrtDate() {
        return crtDate;
    }
    public Long getBidAmount() {
        return bidAmount;
    }
    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }


    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getUptDate() {
        return uptDate;
    }
    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setUptDate(String uptDate) {
        this.uptDate = uptDate;
    }

    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }
    public void setBeAuctionedYN(String beAuctionedYN) {
        this.beAuctionedYN = beAuctionedYN;
    }

    public String getBeAuctionedYN() {
        return beAuctionedYN;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public String getTitle() {
        return title;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getPaymentGubun() {
        return paymentGubun;
    }
    public String getPaymentResult() {
        return paymentResult;
    }
    public void setPaymentGubun(String paymentGubun) {
        this.paymentGubun = paymentGubun;
    }

    public void setPaymentResult(String paymentResult) {
        this.paymentResult = paymentResult;
    }




}
