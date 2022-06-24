package com.example.auction.kafka;

import com.example.auction.domain.AucPayment;
import com.example.auction.domain.Auction;
import com.example.auction.domain.Payment;
import com.example.auction.domain.service.AucPaymentRegistered;
import com.example.auction.domain.service.AucRegisterd;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaPublisher kafkaPublisher;

    //private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8085").build();
    private WebClient webClient = WebClient.builder().baseUrl("http://192.168.72.103:8085").build();

    @GetMapping("/push/{message}")
    public void pushTest(@PathVariable String message) {
        kafkaPublisher.sendAuctionString(message);
    }

    @PostMapping("/auction/push")
    public void pushJsonTest(@RequestBody String auction) throws ParseException {
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

    @PostMapping("/auction/userpush")
    public void pushJsonUser(@RequestBody String auction) throws ParseException {
        log.info("send : {}", auction);
        log.info("sendUserRequest  "+ str2Obj(auction));

        kafkaPublisher.sendUserAuctionJson(str2Obj(auction));
    }


    public Object str2Obj(String str) throws ParseException {
        JSONParser parser = new JSONParser();
        return parser.parse(str);
    }

    //Hystrix Test(로컬테스트용)
    @PostMapping("/auction/pushHystrix")
    @HystrixCommand(fallbackMethod = "getHystrixFallback")
    public Payment pushJsonHystrix(@RequestBody String auction) throws ParseException {
        log.info("sendHystrixRequest : {}", str2Obj(auction));


        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("postTitle", "Hystrix Title");
        return webClient.post()
                .uri("/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(str2Obj(auction))
                .retrieve()
                .bodyToMono(Payment.class)
                .block();
    }

    private Payment getHystrixFallback(@RequestBody String auction) {
        log.info("Circuit Breaker Opened");
        return null;
    }



}
