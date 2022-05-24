package com.example.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Bid;
import com.example.auction.domain.repository.AuctionRepository;
import com.example.auction.domain.repository.BidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PolicyHandlerTest {

    @Autowired
    private  AuctionRepository auctionRepository;

    @Autowired
    private BidRepository bidRepository;

    @Test
    void wheneverBidRegisted() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("9999"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverBidRegisted2() {
        // given
        Bid bid = new Bid();
        bid.setAucPostId(Long.parseLong("8888"));
        bid.setBidId(Long.parseLong("1"));
        // when
        Bid saveBid = bidRepository.save(bid);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(bid.getAucPostId()).isEqualTo(saveBid.getAucPostId());
        Assertions.assertThat(saveBid.getAucPostId()).isNotNull();
        Assertions.assertThat(bidRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverAucPaymentRegisted() {
        // given
        Bid bid = new Bid();
        bid.setAucPostId(Long.parseLong("7777"));
        bid.setBidId(Long.parseLong("1"));
        // when
        Bid saveBid = bidRepository.save(bid);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(bid.getAucPostId()).isEqualTo(saveBid.getAucPostId());
        Assertions.assertThat(saveBid.getAucPostId()).isNotNull();
        Assertions.assertThat(bidRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverAucRegistered() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("6666"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverAucRegistered2() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("5555"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverBeAuctioned() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("4444"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }

    @Test
    void wheneverAucPaymentRegisted2() {
        // given
        Auction auction = new Auction();
        auction.setAucPostId(Long.parseLong("3333"));
        auction.setStatus("Test");
        auction.setAucId(Long.parseLong("1"));
        // when
        Auction saveAuction = auctionRepository.save(auction);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(auction.getAucPostId()).isEqualTo(saveAuction.getAucPostId());
        Assertions.assertThat(saveAuction.getAucPostId()).isNotNull();
        Assertions.assertThat(auctionRepository.count()).isEqualTo(1);
    }




}