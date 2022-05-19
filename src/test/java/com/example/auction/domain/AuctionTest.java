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
}