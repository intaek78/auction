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
        auction2.setAucId(Long.parseLong("9999"));
        auction2.setStatus("test");
        Auction auc2 = auctionRepository.save(auction2);

        AucPaymentRegistered aucPaymentRegistered = new AucPaymentRegistered();
        aucPaymentRegistered.setAucId(Long.parseLong("9999"));
        aucPaymentRegistered.setPaymentGubun("END");
        System.out.println("aucPaymentRegistered.getAucId()=> "+aucPaymentRegistered.getAucId());
        System.out.println("auc2 AucId : " + auc2.getAucId());
        System.out.println("auc2 ProcGUBUN : " + auc2.getProcGUBUN());
        System.out.println("auc2 Status : " + auc2.getStatus());

        auctionRepository.findByAucId((aucPaymentRegistered.getAucId())).ifPresent(auction->{
            System.out.println("1111111111111");
            auction.setProcGUBUN("B");
            System.out.println("2222222222222");
            auction.setStatus("END");
            System.out.println("3333333333333");
            auctionRepository.save(auction);
            System.out.println("444444444444444444");
        });

        System.out.println("123123123123123");

        //Optional<Auction> aa3 = auctionRepository.findByAucId(Long.parseLong("9999"));
        //System.out.println(aa3.get().getProcGUBUN());
        //System.out.println("aucPaymentRegistered.getAucId()==> " + aucPaymentRegistered.getAucId());


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