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
    public void wheneverPaymentResulted_(@Payload Payment payment){
        System.out.println("????????????????Receive PaymentResult?????????????????");
        System.out.println("kafka Subscriber string==> " + payment.getPaymentResult());
        List<Auction> auctionList = auctionRepository.findByAucPostId(payment.getPostId());
        for(Auction auction:auctionList){
            if(payment.getPaymentGubun().equals("REQUEST_PAYMENT")&&payment.getPaymentResult().equals("APPROVED")){
                auction.setStatus(payment.getPaymentGubun() + " APPROVED");
                auction.setProc_GUBUN("PAYMENT END");
                auction.setPaymentReq_YN("Y");
                System.out.println("APPROVED==>" + payment.getPaymentGubun() + " APPROVED");
            }else if(payment.getPaymentGubun().equals("REQUEST_PAYMENT")&&payment.getPaymentResult().equals("REJECTED")){
                auction.setStatus(payment.getPaymentGubun() + " REJECTED");
                auction.setProc_GUBUN("PAYMENT REJECT");
                System.out.println("REJECTED==>" + payment.getPaymentGubun() + " REJECTED");
            }else if(payment.getPaymentGubun().equals("CANCEL_PAYMENT")&&payment.getPaymentResult().equals("APPROVED")){
                auction.setStatus(payment.getPaymentGubun() + " APPROVED");
                auction.setProc_GUBUN("PAYMENT CANCELED");
                auction.setPaymentReq_YN("N"); //다시 결제요청할 수 있도록
                System.out.println("APPROVED==>" + payment.getPaymentGubun() + " APPROVED");
            }else if(payment.getPaymentGubun().equals("CANCEL_PAYMENT")&&payment.getPaymentResult().equals("REJECTED")){
                auction.setStatus(payment.getPaymentGubun() + " REJECTED");
                auction.setProc_GUBUN("PAYMENT CANCEL REJECTED");
                System.out.println("REJECTED==>" + payment.getPaymentGubun() + " REJECTED");
            }
            auctionRepository.save(auction);
        }
    }

    public Object str2Obj(String str) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(str);
        return jsonObject;
    }

}