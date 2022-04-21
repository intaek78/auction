package com.example.auction.domain.service;

import com.example.auction.AbstractEvent;

public class AucRegisterd extends AbstractEvent {

    private Long aucId;

    private Long aucId2;
    private Long aucPostId;
    private String title;
    private String content;
    private String status;
    private Long auc_amount;
    private String pay_mth;
    private String crt_date;
    private String upt_date;
    private Long auctioned_mem_id;
    private String complete_yn;

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

    public Long getAuc_amount() {
        return auc_amount;
    }
    public void setAuc_amount(Long auc_amount) {
        this.auc_amount = auc_amount;
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

    public Long getAuctioned_mem_id() {
        return auctioned_mem_id;
    }
    public void setAuctioned_mem_id(Long auctioned_mem_id) {
        this.auctioned_mem_id = auctioned_mem_id;
    }

    public String getComplete_yn() {
        return complete_yn;
    }
    public void setComplete_yn(String complete_yn) {
        this.complete_yn = complete_yn;
    }

}