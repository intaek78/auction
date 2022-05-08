package com.example.auction.domain;

import com.example.auction.domain.service.AucRegisterd;
import com.example.auction.domain.service.AuctionCancelled;
import com.example.auction.domain.service.AuctionCompleted;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name="AuctionPost_table")
public class AuctionPost {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long postId;
    private Long aucId2;
    private Long aucPostId;
    private String title;
    private String content;
    private String status;
    private Long auc_start_amount;
    private String pay_mth;
    private String crt_date;
    private String upt_date;
    private Long buyerId;
    private Long sellerId;
    private String proc_GUBUN;
    private String beAuctioned_date;
    private Long beAuctioned_amount;

    private String beAuctioned_YN_Auc;

    private String paymentReq_YN;


    @PrePersist
    public void onPrePersist(){
        proc_GUBUN = "R";
    }


    @PostPersist
    public void onPostPersist(){
    }

    @PostUpdate
    public void onPostUpdate(){

    }

    @PreRemove
    public void onPreRemove(){
    }


    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
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

    public Long getAuc_start_amount() {
        return auc_start_amount;
    }
    public void setAuc_start_amount(Long auc_start_amount) {
        this.auc_start_amount = auc_start_amount;
    }

    public String getPay_mth() {
        return pay_mth;
    }
    public void setPay_mth(String pay_mth) {
        this.pay_mth = pay_mth;
    }

    public String getCrt_date() {
        return crt_date;
    }
    public void setCrt_date(String crt_date) {
        this.crt_date = crt_date;
    }

    public String getUpt_date() {
        return upt_date;
    }
    public void setUpt_date(String upt_date) {
        this.upt_date = upt_date;
    }

    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }

    public String getBeAuctioned_date() {
        return beAuctioned_date;
    }
    public void setBeAuctioned_date(String beAuctioned_date) {
        this.beAuctioned_date = beAuctioned_date;
    }

    public Long getBeAuctioned_amount() {
        return beAuctioned_amount;
    }
    public void setBeAuctioned_amount(Long beAuctioned_amount) {
        this.beAuctioned_amount = beAuctioned_amount;
    }

    public String getBeAuctioned_YN_Auc() {
        return beAuctioned_YN_Auc;
    }
    public void setBeAuctioned_YN_Auc(String beAuctioned_YN_Auc) {
        this.beAuctioned_YN_Auc = beAuctioned_YN_Auc;
    }

    public String getPaymentReq_YN() {
        return paymentReq_YN;
    }
    public void setPaymentReq_YN(String paymentReq_YN) {
        this.paymentReq_YN = paymentReq_YN;
    }





}
