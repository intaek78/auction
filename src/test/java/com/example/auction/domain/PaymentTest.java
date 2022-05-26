package com.example.auction.domain;

import com.example.auction.domain.repository.BidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PaymentTest {

    @Test
    void onPostPersist() {
        Payment payment = new Payment();
        payment.setAmount(Long.parseLong("100000"));
        payment.setId(Long.parseLong("100000"));
        payment.setPaymentGubun("END");
        payment.setProcGUBUN("END");
        payment.setSeller(Long.parseLong("100000"));
        payment.setPaymentReqYN("Y");
        payment.setPaymentResult("Approved");
        payment.setPostId(Long.parseLong("100000"));
        payment.setAucId(Long.parseLong("100000"));
        payment.setBeAuctionedDate("20220606");
        payment.setBeAuctionedYN("Y");
        payment.setPostGubun("AUCTION");
        payment.setBidId(Long.parseLong("100000"));
        payment.setBidId2(Long.parseLong("100000"));
        payment.setBidMemId(Long.parseLong("100000"));
        payment.setBuyer(Long.parseLong("100000"));
        payment.setCrtDate("20220606");
        payment.setUptDate("20220606");
        payment.setPostTitle("title");

        Assertions.assertThat(payment.getPostGubun()).isNotNull();
        Assertions.assertThat(payment.getAmount()).isNotNull();
        Assertions.assertThat(payment.getPaymentReqYN()).isNotNull();
        Assertions.assertThat(payment.getPaymentGubun()).isNotNull();
        Assertions.assertThat(payment.getCrtDate()).isNotNull();
        Assertions.assertThat(payment.getUptDate()).isNotNull();
        Assertions.assertThat(payment.getAucId()).isNotNull();
        Assertions.assertThat(payment.getPaymentResult()).isNotNull();
        Assertions.assertThat(payment.getId()).isNotNull();
        Assertions.assertThat(payment.getPostId()).isNotNull();
        Assertions.assertThat(payment.getBidId()).isNotNull();
        Assertions.assertThat(payment.getBidId2()).isNotNull();
        Assertions.assertThat(payment.getBidMemId()).isNotNull();
        Assertions.assertThat(payment.getBeAuctionedDate()).isNotNull();
        Assertions.assertThat(payment.getPostTitle()).isNotNull();
        Assertions.assertThat(payment.getBeAuctionedYN()).isNotNull();
        Assertions.assertThat(payment.getProcGUBUN()).isNotNull();
        Assertions.assertThat(payment.getSeller()).isNotNull();
        Assertions.assertThat(payment.getBuyer()).isNotNull();

        payment.onPostPersist();
    }
}