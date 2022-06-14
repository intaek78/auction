package com.example.auction.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaProcessor {

    String PAYMENT_OUTPUT = "payment-out";
    String PAYMENT_INPUT = "payment-in";
    @Output(PAYMENT_OUTPUT)
    MessageChannel paymentOutboundTopic();

    @Input(PAYMENT_INPUT)
    MessageChannel paymentInboundTopic();

    String INPUT = "auction-in";
    String OUTPUT = "auction-out";

    String HISTORY_OUTPUT = "history-out";
    @Output(HISTORY_OUTPUT)
    MessageChannel historyOutboundTopic();

    @Input(INPUT)
    SubscribableChannel inboundTopic();

    @Output(OUTPUT)
    MessageChannel outboundTopic();

    String USER_OUTPUT = "user-out";
    String USER_INPUT = "user-in";
    @Output(USER_OUTPUT)
    MessageChannel userOutboundTopic();

    @Input(USER_INPUT)
    MessageChannel userInboundTopic();
}
