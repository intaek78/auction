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

    @Output(PAYMENT_INPUT)
    MessageChannel paymentInboundTopic();

    String INPUT = "auction-in";
    String OUTPUT = "auction-out";

    @Input(INPUT)
    SubscribableChannel inboundTopic();

    @Output(OUTPUT)
    MessageChannel outboundTopic();
}
