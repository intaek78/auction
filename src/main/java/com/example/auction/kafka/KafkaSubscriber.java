package com.example.auction.kafka;

import com.example.auction.domain.Auction;
import com.example.auction.domain.Payment;
import com.example.auction.domain.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    public void wheneverPaymentResulted(@Payload Payment payment){
        log.info("????????????????Receive PaymentResult?????????????????");
        log.info("kafka Subscriber string==> " + payment.getPaymentResult());
        List<Auction> auctionList = auctionRepository.findByAucPostId(payment.getPostId());
        String appro = " APPROVED";
        String rejec = " REJECTED";
        for(Auction auction:auctionList){
            if(payment.getPaymentGubun().equals("REQUEST_PAYMENT")&&payment.getPaymentResult().equals("APPROVED")){
                auction.setStatus(payment.getPaymentGubun() + appro);
                auction.setProcGUBUN("PAYMENT END");
                auction.setPaymentReqYN("Y");
            }else if(payment.getPaymentGubun().equals("REQUEST_PAYMENT")&&payment.getPaymentResult().equals("REJECTED")){
                auction.setStatus(payment.getPaymentGubun() + rejec);
                auction.setProcGUBUN("PAYMENT REJECT");
            }else if(payment.getPaymentGubun().equals("CANCEL_PAYMENT")&&payment.getPaymentResult().equals("APPROVED")){
                auction.setStatus(payment.getPaymentGubun() + appro);
                auction.setProcGUBUN("PAYMENT CANCELED");
                auction.setPaymentReqYN("N"); //다시 결제요청할 수 있도록
            }else if(payment.getPaymentGubun().equals("CANCEL_PAYMENT")&&payment.getPaymentResult().equals("REJECTED")){
                auction.setStatus(payment.getPaymentGubun() + rejec);
                auction.setProcGUBUN("PAYMENT CANCEL REJECTED");
            }
            auctionRepository.save(auction);
        }
    }

    public Object str2Obj(String str) throws ParseException {
        JSONParser parser = new JSONParser();
        return parser.parse(str);
    }

}