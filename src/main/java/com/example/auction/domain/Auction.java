package com.example.auction.domain;

import javax.persistence.*;

import com.example.auction.domain.service.AucRegisterd;
import com.example.auction.domain.service.AuctionCancelled;
import com.example.auction.domain.service.AuctionCompleted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Slf4j
@Entity
@Table(name="Auction_table")
public class Auction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long aucId;
    private String aucEndDate;
    private Long aucId2;
    private Long aucPostId;
    private String paymentReqYN;
    private String title;
    private String content;
    private String status;
    private String beAuctionedYnAuc;
    private Long aucStartAmount;
    private Long beAuctionedAmount;
    private String payMth;
    private String procGUBUN;
    private String crtDate;
    private String beAuctionedDate;
    private String uptDate;
    private String aucStartDate;
    private Long buyerId;
    private Long sellerId;
    private String completeYn;


    @PrePersist
    public void onPrePersist(){
        procGUBUN = "R";
    }


    @PostPersist
    public void onPostPersist(){
        AucRegisterd aucRegisterd = new AucRegisterd();
        BeanUtils.copyProperties(this, aucRegisterd);
        if (!this.procGUBUN.equals("PAYMENT REJECT")) {
            aucRegisterd.publishAfterCommit();
        }

    }

    @PostUpdate
    public void onPostUpdate(){
        //경매취소/완료 처리
        AuctionCancelled auctionCancelled = new AuctionCancelled();
        BeanUtils.copyProperties(this, auctionCancelled);

        AuctionCompleted auctionCompleted = new AuctionCompleted();
        BeanUtils.copyProperties(this, auctionCompleted);
        log.info("this.proc_GUBUN====>"+this.procGUBUN);
        if (this.procGUBUN.equals("PAYMENT CANCELED")) {
            auctionCancelled.publishAfterCommit();
        }else if(this.procGUBUN.equals("E")){
            auctionCompleted.publishAfterCommit();
        }


    }

    @PreRemove
    public void onPreRemove(){
        AuctionCancelled auctionCancelled = new AuctionCancelled();
        BeanUtils.copyProperties(this, auctionCancelled);
        auctionCancelled.publishAfterCommit();
    }


    public Long getAucId() {
        return aucId;
    }
    public void setAucEndDate(String aucEndDate) {
        this.aucEndDate = aucEndDate;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }
    public void setAucId2(Long aucId2) {
        this.aucId2 = aucId2;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }
    public Long getAucId2() {
        return aucId2;
    }

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public String getPayMth() {
        return payMth;
    }

    public Long getAucStartAmount() {
        return aucStartAmount;
    }
    public void setAucStartAmount(Long aucStartAmount) {
        this.aucStartAmount = aucStartAmount;
    }


    public void setPayMth(String payMth) {
        this.payMth = payMth;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getBeAuctionedDate() {
        return beAuctionedDate;
    }
    public void setBeAuctionedDate(String beAuctionedDate) {
        this.beAuctionedDate = beAuctionedDate;
    }


    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getProcGUBUN() {
        return procGUBUN;
    }
    public void setProcGUBUN(String procGUBUN) {
        this.procGUBUN = procGUBUN;
    }

    public String getCrtDate() {
        return crtDate;
    }


    public String getBeAuctionedYnAuc() {
        return beAuctionedYnAuc;
    }
    public void setBeAuctionedYnAuc(String beAuctionedYnAuc) {
        this.beAuctionedYnAuc = beAuctionedYnAuc;
    }
    public Long getBeAuctionedAmount() {
        return beAuctionedAmount;
    }
    public void setBeAuctionedAmount(Long beAuctionedAmount) {
        this.beAuctionedAmount = beAuctionedAmount;
    }

    public String getAucEndDate() {
        return aucEndDate;
    }

    public String getPaymentReqYN() {
        return paymentReqYN;
    }
    public void setPaymentReqYN(String paymentReqYN) {
        this.paymentReqYN = paymentReqYN;
    }

    public String getAucStartDate() {
        return aucStartDate;
    }
    public void setAucStartDate(String aucStartDate) {
        this.aucStartDate = aucStartDate;
    }

    public String getUptDate() {
        return uptDate;
    }
    public void setUptDate(String uptDate) {
        this.uptDate = uptDate;
    }

    public String getCompleteYn() {
        return completeYn;
    }
    public void setCompleteYn(String completeYn) {
        this.completeYn = completeYn;
    }  




}
