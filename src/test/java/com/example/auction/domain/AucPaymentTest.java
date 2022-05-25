<<<<<<< Updated upstream
package com.example.auction.domain;

import com.example.auction.domain.repository.AucPaymentRepository;
import com.example.auction.domain.repository.AuctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AucPaymentTest {

    @Autowired
    private AucPaymentRepository  aucPaymentRepository;

    @Test
    void onPostPersist() {
        AucPayment aucPayment = new AucPayment();
        aucPayment.setBidId(Long.parseLong("9999"));
        aucPayment.setTitle("TestTitle");
        aucPayment.setBidId2(Long.parseLong("9999"));
        aucPayment.setAucPostId(Long.parseLong("1111"));
        aucPayment.setAucId(Long.parseLong("11"));
        aucPayment.setPaymentReqYN("Y");
        aucPayment.setBeAuctionedDate("20220505");
        aucPayment.setBeAuctionedYN("Y");
        aucPayment.setBidAmount(Long.parseLong("50000"));
        aucPayment.setBidMemId(Long.parseLong("5600"));
        aucPayment.setCrtDate("20220504");
        aucPayment.setProcGUBUN("END");
        aucPayment.setSellerId(Long.parseLong("4000"));
        aucPayment.setUptDate("20220606");
        aucPayment.setPaymentGubun("AUCTION");
        aucPayment.setPaymentResult("approve");
        aucPayment.setPaymentResult("approve");

        // when
        AucPayment saveAucPayment = aucPaymentRepository.save(aucPayment);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(aucPayment.getTitle()).isEqualTo(saveAucPayment.getTitle());
        Assertions.assertThat(aucPayment.getBidId2()).isEqualTo(saveAucPayment.getBidId2());
        Assertions.assertThat(aucPayment.getBidMemId()).isEqualTo(saveAucPayment.getBidMemId());
        Assertions.assertThat(aucPayment.getCrtDate()).isEqualTo(saveAucPayment.getCrtDate());
        Assertions.assertThat(aucPayment.getBidAmount()).isEqualTo(saveAucPayment.getBidAmount());
        Assertions.assertThat(aucPayment.getUptDate()).isEqualTo(saveAucPayment.getUptDate());
        Assertions.assertThat(aucPayment.getBeAuctionedYN()).isEqualTo(saveAucPayment.getBeAuctionedYN());
        Assertions.assertThat(aucPayment.getSellerId()).isEqualTo(saveAucPayment.getSellerId());
        Assertions.assertThat(saveAucPayment.getTitle()).isNotNull();
        Assertions.assertThat(aucPaymentRepository.count()).isEqualTo(1);
    }

=======
package com.example.auction.domain;

import com.example.auction.domain.repository.AucPaymentRepository;
import com.example.auction.domain.repository.AuctionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AucPaymentTest {

    @Autowired
    private AucPaymentRepository  aucPaymentRepository;

    @Test
    void onPostPersist() {
        AucPayment aucPayment = new AucPayment();
        aucPayment.setBidId(Long.parseLong("9999"));
        aucPayment.setTitle("TestTitle");
        aucPayment.setBidId2(Long.parseLong("9999"));
        aucPayment.setAucPostId(Long.parseLong("1111"));
        aucPayment.setAucId(Long.parseLong("11"));
        aucPayment.setPaymentReqYN("Y");
        aucPayment.setBeAuctionedDate("20220505");
        aucPayment.setBeAuctionedYN("Y");
        aucPayment.setBidAmount(Long.parseLong("50000"));
        aucPayment.setBidMemId(Long.parseLong("5600"));
        aucPayment.setCrtDate("20220504");
        aucPayment.setProcGUBUN("END");
        aucPayment.setSellerId(Long.parseLong("4000"));
        aucPayment.setUptDate("20220606");
        aucPayment.setPaymentGubun("AUCTION");
        aucPayment.setPaymentResult("approve");

        // when
        AucPayment saveAucPayment = aucPaymentRepository.save(aucPayment);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(aucPayment.getTitle()).isEqualTo(saveAucPayment.getTitle());
        Assertions.assertThat(aucPayment.getBidId2()).isEqualTo(saveAucPayment.getBidId2());
        Assertions.assertThat(aucPayment.getBidMemId()).isEqualTo(saveAucPayment.getBidMemId());
        Assertions.assertThat(aucPayment.getCrtDate()).isEqualTo(saveAucPayment.getCrtDate());
        Assertions.assertThat(aucPayment.getBidAmount()).isEqualTo(saveAucPayment.getBidAmount());
        Assertions.assertThat(aucPayment.getUptDate()).isEqualTo(saveAucPayment.getUptDate());
        Assertions.assertThat(aucPayment.getBeAuctionedYN()).isEqualTo(saveAucPayment.getBeAuctionedYN());
        Assertions.assertThat(aucPayment.getSellerId()).isEqualTo(saveAucPayment.getSellerId());
        Assertions.assertThat(saveAucPayment.getTitle()).isNotNull();
        Assertions.assertThat(aucPaymentRepository.count()).isEqualTo(1);
    }

>>>>>>> Stashed changes
}