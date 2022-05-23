package com.example.auction.domain;

import com.example.auction.domain.repository.AucPaymentRepository;
import com.example.auction.domain.repository.AuctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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
    }

    @Test
    void onPostUpdate() {
        AucPayment aucPayment = new AucPayment();
        aucPayment.setAucPostId(Long.parseLong("9999"));
        assumeTrue(() ->
                aucPayment.getAucPostId().equals(9999)
        );
          aucPaymentRepository.save(aucPayment);

    }

    @Test
    void onPreRemove() {

    }
}