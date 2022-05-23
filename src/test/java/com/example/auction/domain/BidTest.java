package com.example.auction.domain;

import com.example.auction.domain.repository.BidRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
class BidTest {

    @Autowired
    private BidRepository bidRepository;

    @Test
    void onPostPersist() {
        Bid bid = new Bid();
        bid.setAucId(Long.parseLong("9999"));
        bid.setAucPostId(Long.parseLong("1234"));
        bid.setStatus("test");
        bid.setBidId2(Long.parseLong("9999"));
        bid.setPaymentReqYN("Y");
        bid.setBidMemId(Long.parseLong("9999"));
        bid.setSellerId(Long.parseLong("9999"));
        bid.setBidAmount(Long.parseLong("10000"));
        bid.setCrtDate("20220606");
        bid.setUptDate("20220606");
        bid.setTitle("title");
        bid.setBeAuctionedDate("20220606");
        bid.setProcGUBUN("END");
        bid.setBeAuctionedYN("Y");

        Bid saveBid = bidRepository.save(bid);

        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(saveBid.getAucPostId()).isEqualTo(saveBid.getAucPostId());
        Assertions.assertThat(saveBid.getAucPostId()).isNotNull();
        Assertions.assertThat(saveBid.getStatus()).isNotNull();
        Assertions.assertThat(saveBid.getPaymentReqYN()).isNotNull();
        Assertions.assertThat(saveBid.getSellerId()).isNotNull();
        Assertions.assertThat(saveBid.getCrtDate()).isNotNull();
        Assertions.assertThat(saveBid.getUptDate()).isNotNull();
        Assertions.assertThat(saveBid.getTitle()).isNotNull();
        Assertions.assertThat(saveBid.getBeAuctionedDate()).isNotNull();
        Assertions.assertThat(saveBid.getBeAuctionedYN()).isNotNull();
        Assertions.assertThat(bidRepository.count()).isEqualTo(1);
    }

}