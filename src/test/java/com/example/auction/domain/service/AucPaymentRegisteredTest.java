package com.example.auction.domain.service;

import com.example.auction.domain.AucPayment;
import com.example.auction.domain.repository.AucPaymentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AucPaymentRegisteredTest {

    @Autowired
    private AucPaymentRepository aucPaymentRepository;

    @Test
    void doTest() {
        AucPayment aucPayment = new AucPayment();
        aucPayment.setBidId(Long.parseLong("9999"));
        aucPayment.setBeAuctionedAmount(Long.parseLong("1000000"));
        aucPayment.setAuctionedMemId(Long.parseLong("9999"));

        AucPayment saveAucPayment = aucPaymentRepository.save(aucPayment);
        // then
        //Assertions.assertThat(auction).isSameAs(saveAuction);
        Assertions.assertThat(aucPayment.getTitle()).isEqualTo(saveAucPayment.getTitle());
        Assertions.assertThat(aucPayment.getBidId2()).isEqualTo(saveAucPayment.getBidId2());
    }


}