package com.example.auction.domain;

import com.example.auction.domain.repository.BeauctionRepository;
import com.example.auction.domain.repository.BidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeauctionTest {

    @Autowired
    private BeauctionRepository beauctionRepository;

    @Test
    void onPostPersist() {
        Beauction beauction = new Beauction();
        beauction.setBeauctionId(Long.parseLong("9999"));
        beauction.setAucId(Long.parseLong("9999"));
        beauction.setBidId(Long.parseLong("9999"));
        beauction.setAucPostId(Long.parseLong("9999"));
        beauction.setBeauctionId(Long.parseLong("9999"));
        beauction.setBidMemId(Long.parseLong("9999"));
        beauction.setCrtDate("20220606");
        beauction.setBeAuctionedDate("30330606");
        beauction.setBeAuctionedYN("Y");
        beauction.setProcGUBUN("END");
        beauction.setUptDate("20220606");

        Beauction saveBeAuction = beauctionRepository.save(beauction);

        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(beauction.getAucPostId()).isEqualTo(saveBeAuction.getAucPostId());
        Assertions.assertThat(saveBeAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(saveBeAuction.getAucId()).isNotNull();
        Assertions.assertThat(saveBeAuction.getBidId()).isNotNull();
        Assertions.assertThat(saveBeAuction.getBeauctionId()).isNotNull();
        Assertions.assertThat(saveBeAuction.getCrtDate()).isNotNull();
        Assertions.assertThat(saveBeAuction.getUptDate()).isNotNull();
        Assertions.assertThat(saveBeAuction.getBidMemId()).isNotNull();
        Assertions.assertThat(saveBeAuction.getBeAuctionedDate()).isNotNull();
        Assertions.assertThat(saveBeAuction.getBeAuctionedYN()).isNotNull();
        Assertions.assertThat(beauctionRepository.count()).isEqualTo(1);
    }
}