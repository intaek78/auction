package com.example.auction.domain.service;

import com.example.auction.domain.Auction;
import com.example.auction.domain.repository.AuctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuctionCompletedTest {

    @Test
    void doTestAucCompleted() {
        AuctionCompleted auctionCompleted = new AuctionCompleted();
        auctionCompleted.setAucPostId(Long.parseLong("9999"));
        auctionCompleted.setStatus("Test");
        auctionCompleted.setAucId(Long.parseLong("1"));
        auctionCompleted.setBuyerId(Long.parseLong("5626"));
        auctionCompleted.setBeAuctionedAmount(Long.parseLong("10000"));
        auctionCompleted.setSellerId(Long.parseLong("5000"));
        auctionCompleted.setProcGUBUN("END");
        auctionCompleted.setBeAuctionedDate("20220606");

        Assertions.assertThat(auctionCompleted.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionCompleted.getStatus()).isNotNull();
        Assertions.assertThat(auctionCompleted.getAucId()).isNotNull();
        Assertions.assertThat(auctionCompleted.getBuyerId()).isNotNull();
        Assertions.assertThat(auctionCompleted.getBeAuctionedAmount()).isNotNull();
        Assertions.assertThat(auctionCompleted.getSellerId()).isNotNull();
        Assertions.assertThat(auctionCompleted.getProcGUBUN()).isNotNull();
        Assertions.assertThat(auctionCompleted.getBeAuctionedDate()).isNotNull();

    }

}