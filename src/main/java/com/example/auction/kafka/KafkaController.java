package com.example.auction.kafka;

import com.example.auction.domain.AucPayment;
import com.example.auction.domain.Auction;
import com.example.auction.domain.service.AucPaymentRegistered;
import com.example.auction.domain.service.AucRegisterd;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaPublisher kafkaPublisher;

    @GetMapping("/push/{message}")
    public void pushTest(@PathVariable String message) {
        log.info("전송 : {}", message);
        kafkaPublisher.sendAuctionString(message);
    }

    @PostMapping("/auction/push")
    public void pushJsonTest(@RequestBody String auction) throws ParseException {
        log.info("전송 : {}", auction);
        log.info("sendPaymentRequest  "+ str2Obj(auction));

        kafkaPublisher.sendAuctionJson(str2Obj(auction));
    }

    @PostMapping("/auction/pushhistory")
    public void pushJsonHistory(@RequestBody String auction) throws ParseException {
        log.info("sendHistoryRequest : {}", str2Obj(auction));
        kafkaPublisher.sendAucHistoryJson(str2Obj(auction));
    }

    @PostMapping("/auction/registPost")
    public void pushJsonAuctionPost(@RequestBody String auction) throws ParseException {
        log.info("pushJsonAuctionPost : {}", str2Obj(auction));
        kafkaPublisher.sendAucPostJson(str2Obj(auction));
    }


    public Object str2Obj(String str) throws ParseException {
        JSONParser parser = new JSONParser();
        return parser.parse(str);
    }

}
