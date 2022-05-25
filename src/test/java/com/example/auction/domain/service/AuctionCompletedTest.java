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

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    void doTestAucCompleted() {

    }

}