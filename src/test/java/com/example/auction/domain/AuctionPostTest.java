package com.example.auction.domain;

import com.example.auction.domain.repository.AuctionPostRepository;
import com.example.auction.domain.repository.BeauctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuctionPostTest {

    @Autowired
    private AuctionPostRepository auctionPostRepository;

    @Test
    void doTestAuc() {
        AuctionPost auctionPost = new AuctionPost();
        auctionPost.setPostId(Long.parseLong("9999"));
        auctionPost.setAucId2(Long.parseLong("9999"));
        auctionPost.setBeAuctionedAmount(Long.parseLong("100000"));
        auctionPost.setTitle("title");
        auctionPost.setContent("CONTENT");
        auctionPost.setAucPostId(Long.parseLong("9999"));
        auctionPost.setAucStartAmount(Long.parseLong("9999"));
        auctionPost.setPayMth("SV");
        auctionPost.setCrtDate("20220606");
        auctionPost.setBeAuctionedDate("30330606");
        auctionPost.setStatus("Y");
        auctionPost.setProcGUBUN("END");
        auctionPost.setUptDate("20220606");
        auctionPost.setBuyerId(Long.parseLong("9999"));
        auctionPost.setSellerId(Long.parseLong("9999"));
        auctionPost.setPaymentReqYN("Y");
        auctionPost.setBeAuctionedYnAuc("Y");

        AuctionPost saveAuctionPost = auctionPostRepository.save(auctionPost);

        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auctionPost.getAucPostId()).isEqualTo(saveAuctionPost.getAucPostId());
        Assertions.assertThat(saveAuctionPost.getAucPostId()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getAucId2()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getPostId()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getTitle()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getContent()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getCrtDate()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getUptDate()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getStatus()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getPayMth()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getSellerId()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getBuyerId()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getProcGUBUN()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getStatus()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getBeAuctionedAmount()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getBeAuctionedYnAuc()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getPaymentReqYN()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getBeAuctionedDate()).isNotNull();
        Assertions.assertThat(saveAuctionPost.getAucStartAmount()).isNotNull();
        Assertions.assertThat(auctionPostRepository.count()).isEqualTo(1);
    }
}