package com.example.auction.kafka;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Payment;
import com.example.auction.domain.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaSubscriber {

    @Autowired AuctionRepository auctionRepository;

    //결제요청/취소 응답
    @StreamListener(KafkaProcessor.PAYMENT_INPUT)
    public void wheneverPaymentResulted_(@Payload Payment payment){
        System.out.println("????????????????auction 234?????????????????");
        List<Auction> auctionList = auctionRepository.findByAucPostId(payment.getPostId());
        for(Auction auction:auctionList){
            auction.setCrt_date(payment.getPaymentResult());
            System.out.println("auction status : "+payment.getPaymentResult() );
            auctionRepository.save(auction);
        }
    }

}