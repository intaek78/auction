<<<<<<< Updated upstream
package com.example.auction.domain;

import com.example.auction.domain.repository.AucPaymentRepository;
import com.example.auction.domain.repository.AuctionRepository;
import com.example.auction.domain.service.AucRegisterd;
import com.example.auction.domain.service.AuctionCancelled;
import com.example.auction.domain.service.AuctionCompleted;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DataJpaTest
class AuctionTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private AucPaymentRepository aucPaymentRepository;

    @Test
    void onPostPersist() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("9999"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        auction.setAucEndDate("20200505");
        auction.setAucId2(Long.parseLong("5000"));
        auction.setTitle("title");
        auction.setContent("content");
        auction.setBeAuctionedYnAuc("Y");
        auction.setAucPostId(Long.parseLong("9999"));
        auction.setAucStartAmount(Long.parseLong("9999"));
        auction.setBuyerId(Long.parseLong("5626"));
        auction.setPayMth("SV");
        auction.setCrtDate("20220606");
        auction.setBeAuctionedDate("20220606");
        auction.setSellerId(Long.parseLong("5626"));
        auction.setProcGUBUN("END");
        auction.setBeAuctionedAmount(Long.parseLong("50000"));
        auction.setPaymentReqYN("END");
        auction.setAucStartDate("20220606");
        auction.setUptDate("20220606");
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(saveAuction.getAucStartAmount()).isNotNull();
        Assertions.assertThat(saveAuction.getBuyerId()).isNotNull();
        Assertions.assertThat(saveAuction.getBeAuctionedDate()).isNotNull();
        Assertions.assertThat(saveAuction.getSellerId()).isNotNull();
        Assertions.assertThat(saveAuction.getProcGUBUN()).isNotNull();
        Assertions.assertThat(saveAuction.getBeAuctionedYnAuc()).isNotNull();
        Assertions.assertThat(saveAuction.getBeAuctionedAmount()).isNotNull();
        Assertions.assertThat(saveAuction.getAucEndDate()).isNotNull();
        Assertions.assertThat(saveAuction.getPaymentReqYN()).isNotNull();
        Assertions.assertThat(saveAuction.getAucStartDate()).isNotNull();

        AucRegisterd aucRegisterd = new AucRegisterd();
        BeanUtils.copyProperties(this, aucRegisterd);

        saveAuction.setProcGUBUN("PAYMENT REJECT");
        if(saveAuction.getProcGUBUN().equals("PAYMENT REJECT")){
            aucRegisterd.publishAfterCommit();
        }else{
            AuctionCompleted auctionCompleted = new AuctionCompleted();
            BeanUtils.copyProperties(saveAuction, auctionCompleted);
            auctionCompleted.publishAfterCommit();
        }
    }

    @Test
    void onPostUpdate() {
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("9999"));
        auction.setProcGUBUN("PAYMENT CANCELED");
        Auction saveAuction = auctionRepository.save(auction);
        auction.onPostUpdate();
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(auction.getProcGUBUN()).isEqualTo(saveAuction.getProcGUBUN());


        AuctionCancelled auctionCancelled = new AuctionCancelled();
        AuctionCompleted auctionCompleted = new AuctionCompleted();
        if(saveAuction.getProcGUBUN().equals("PAYMENT CANCELED")){
            auctionCancelled.publishAfterCommit();
        }else{
            auctionCompleted.publishAfterCommit();
        }


    }

    @Test
    void onPreRemove() {
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("9999"));
        Auction saveAuction = auctionRepository.save(auction);
        auction.onPreRemove();
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());

    }
=======
package com.example.auction.domain;

import com.example.auction.domain.repository.AuctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuctionTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    void onPostPersist() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("9999"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        auction.setAucEndDate("20200505");
        auction.setAucId2(Long.parseLong("5000"));
        auction.setTitle("title");
        auction.setContent("content");
        auction.setAucPostId(Long.parseLong("9999"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }

    @Test
    void onPostUpdate() {
    }

    @Test
    void onPreRemove() {
    }
>>>>>>> Stashed changes
}