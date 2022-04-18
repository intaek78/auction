package com.example.auction.domain;

import com.example.auction.domain.service.AucPaymentRegistered;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name="AucPayment_table")
public class AucPayment {

    private Long aucPostId;
    private Long aucId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bidId;
    private Long bidId2;
    private Long bid_mem_id;
    private Long bid_amount;
    private String crt_date;
    private String upt_date;
    private String beAuctioned_date;
    private String beAuctioned_YN;
    private String paymentReq_YN;
    private String proc_GUBUN;
    private String title;
    private Long sellerId;
    private String paymentGubun;


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

    public Long getBidId2() {
        return bidId2;
    }
    public void setBidId2(Long bidId2) {
        this.bidId2 = bidId2;
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

    public Long getBid_mem_id() {
        return bid_mem_id;
    }
    public void setBid_mem_id(Long bid_mem_id) {
        this.bid_mem_id = bid_mem_id;
    }

    public Long getBid_amount() {
        return bid_amount;
    }
    public void setBid_amount(Long bid_amount) {
        this.bid_amount = bid_amount;
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

    public String getBeAuctioned_date() {
        return beAuctioned_date;
    }
    public void setBeAuctioned_date(String beAuctioned_date) {
        this.beAuctioned_date = beAuctioned_date;
    }

    public String getBeAuctioned_YN() {
        return beAuctioned_YN;
    }
    public void setBeAuctioned_YN(String beAuctioned_YN) {
        this.beAuctioned_YN = beAuctioned_YN;
    }

    public String getProc_GUBUN() {
        return proc_GUBUN;
    }
    public void setProc_GUBUN(String proc_GUBUN) {
        this.proc_GUBUN = proc_GUBUN;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getPaymentReq_YN() {
        return paymentReq_YN;
    }
    public void setPaymentReq_YN(String paymentReq_YN) {
        this.paymentReq_YN = paymentReq_YN;
    }

    public String getPaymentGubun() {
        return paymentGubun;
    }
    public void setPaymentGubun(String paymentGubun) {
        this.paymentGubun = paymentGubun;
    }




}
