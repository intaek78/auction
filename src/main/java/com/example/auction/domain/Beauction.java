package com.example.auction.domain;

import com.example.auction.domain.service.BeAuctioned;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Entity
@Table(name="Beauction_table")
public class Beauction {

    private Long aucPostId;
    private Long aucId;
    private String procGUBUN;
    private Long bidId;
    private String beAuctionedYN;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long beauctionId;
    private Long bidMemId;
    private String beAuctionedDate;
    private String crtDate;
    private String uptDate;





    @PostPersist
    public void onPostPersist(){
        log.info("==========Beauction PostPersist start==========");
        //낙찰자id 및 낙찰일시 수정
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        BeAuctioned beAuctioned = new BeAuctioned();
        BeanUtils.copyProperties(this, beAuctioned);
        beAuctioned.setStatus("Sold");
        beAuctioned.setAuctionedMemId(beAuctioned.getAuctionedMemId());
        beAuctioned.setBeAuctionedDate(df.format(cal.getTime()));
        beAuctioned.setBeAuctionedAmount(beAuctioned.getBeAuctionedAmount());
        beAuctioned.setBidId(beAuctioned.getBidId());
        beAuctioned.setProcGUBUN("S");
        beAuctioned.publishAfterCommit();
    }


    public Long getAucId() {
        return aucId;
    }
    public void setAucId(Long aucId) {
        this.aucId = aucId;
    }

    public Long getBidId() {
        return bidId;
    }
    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getAucPostId() {
        return aucPostId;
    }
    public void setAucPostId(Long aucPostId) {
        this.aucPostId = aucPostId;
    }

    public Long getBeauctionId() {
        return beauctionId;
    }
    public void setBeauctionId(Long beauctionId) {
        this.beauctionId = beauctionId;
    }

    public Long getBidMemId() {
        return bidMemId;
    }
    public void setBidMemId(Long bidMemId) {
        this.bidMemId = bidMemId;
    }
    public String getCrtDate() {
        return crtDate;
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

    public String getUptDate() {
        return uptDate;
    }
    public void setUptDate(String uptDate) {
        this.uptDate = uptDate;
    }




}
