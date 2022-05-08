package com.example.auction.kafka;

import com.example.auction.domain.Auction;
import com.example.auction.domain.service.AucPaymentRegistered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaPublisher {

    private final KafkaProcessor kafkaProcessor;
    private final JacksonUtil jacksonUtil;

    /**
     * Kafka로 String 전송
     *
     * @param message
     */
    public void sendAuctionString(String message) {
        kafkaProcessor.paymentOutboundTopic().send(
                MessageBuilder.withPayload(message)
                        .build()
        );
    }

    /**
     * Kafka로 Json 전송
     *
     * @param test
     */
    public void sendAuctionJson(Object auction) {
        String message = jacksonUtil.obj2Str(auction);
        kafkaProcessor.paymentOutboundTopic().send(
                MessageBuilder.withPayload(message)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build()
        );
    }

    public void sendAucHistoryJson(Object auction) {
        String message = jacksonUtil.obj2Str(auction);
        kafkaProcessor.historyOutboundTopic().send(
                MessageBuilder.withPayload(message)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build()
        );
    }


}

