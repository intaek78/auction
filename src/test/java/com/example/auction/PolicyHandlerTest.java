package com.example.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Bid;
import com.example.auction.domain.repository.AuctionRepository;
import com.example.auction.domain.repository.BidRepository;
import com.example.auction.domain.service.AucPaymentRegistered;
import com.example.auction.domain.service.Bidden;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PolicyHandlerTest {

    @Autowired
    private  AuctionRepository auctionRepository;

    @Autowired
    private BidRepository bidRepository;

    Bidden bidden = new Bidden();


    @Test
    void wheneverBidRegisted() {

        Auction auction2 = new Auction();
        auction2.setProcGUBUN("C");
        auction2.setAucPostId(Long.parseLong("111"));
        auction2.setAucId2(Long.parseLong("9999"));
        Auction auc2 = auctionRepository.save(auction2);

        AucPaymentRegistered aucPaymentRegistered = new AucPaymentRegistered();
        aucPaymentRegistered.setAucId(auction2.getAucId());
        aucPaymentRegistered.setAucPostId(Long.parseLong("111"));
        aucPaymentRegistered.setPaymentGubun("END");
        System.out.println("aucPaymentRegistered.getAucId()=> "+aucPaymentRegistered.getAucId());
        System.out.println("auc2 AucId : " + auc2.getAucId());
        System.out.println("auc2 ProcGUBUN : " + auc2.getProcGUBUN());
        System.out.println("auc2 Status : " + auc2.getStatus());

        auctionRepository.findByAucId((aucPaymentRegistered.getAucId())).ifPresent(auction->{
            Assertions.assertThat(auction.getAucPostId()).isEqualTo(aucPaymentRegistered.getAucPostId());
        });


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