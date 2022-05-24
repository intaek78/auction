package com.example.auction;

import com.example.auction.domain.Auction;
import com.example.auction.domain.AuctionPost;
import com.example.auction.domain.Payment;
import com.example.auction.domain.repository.AuctionPostRepository;
import com.example.auction.kafka.KafkaController;
import com.example.auction.kafka.KafkaProcessor;
import com.example.auction.domain.repository.AucPaymentRepository;
import com.example.auction.domain.repository.AuctionRepository;
import com.example.auction.domain.repository.BidRepository;
import com.example.auction.domain.service.AucPaymentRegistered;
import com.example.auction.domain.service.AucRegisterd;
import com.example.auction.domain.service.BeAuctioned;
import com.example.auction.domain.service.Bidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    AucPaymentRepository aucPaymentRepository;

    @Autowired
    AuctionPostRepository auctionPostRepository;


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRegisted(@Payload Bidden bidden){

        if(bidden.isMe()){

            auctionRepository.findByAucId((bidden.getAucId())).ifPresent(auction->{
                auction.setProcGUBUN("B");
                auction.setStatus("<입찰> Buyer:" + bidden.getBidMemId() + ", 금액:" + bidden.getBidAmount());
                auctionRepository.save(auction);
            });
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBidRegisted2(@Payload Bidden bidden2){

        if(bidden2.isMe()){
            bidRepository.findByBidId((bidden2.getBidId())).ifPresent(bid->{
                bid.setBidId2(bidden2.getBidId());
                bidRepository.save(bid);
            });
        }
    }



    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucRegistered(@Payload AucRegisterd aucRegisterd) {
        if (aucRegisterd.isMe()) {
            auctionRepository.findByAucId((aucRegisterd.getAucId())).ifPresent(auction -> {
                auction.setAucId2(aucRegisterd.getAucId()); //임시
                auctionRepository.save(auction);
            });

        }
    }

    //경매글 입력
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucRegistered2(@Payload AucRegisterd aucRegisterd2) {
        if (aucRegisterd2.isMe()) {
            AuctionPost auctionPost = new AuctionPost();
            auctionPost.setAucId2(aucRegisterd2.getAucId());
            auctionPost.setAucPostId(aucRegisterd2.getAucPostId());
            auctionPost.setTitle(aucRegisterd2.getTitle());
            auctionPost.setContent(aucRegisterd2.getContent());

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            cal.add(Calendar.MONTH, 6);
            auctionPost.setCrtDate(df.format(cal.getTime()));

            auctionPostRepository.save(auctionPost);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBeAuctioned(@Payload BeAuctioned beAuctioned){
        //낙찰자/일시/금액 수정
        if(beAuctioned.isMe()){
            auctionRepository.findByAucId((beAuctioned.getAucId())).ifPresent(auction->{
                auction.setBeAuctionedDate(beAuctioned.getBeAuctionedDate()); //임시
                auction.setBuyerId(beAuctioned.getAuctionedMemId());
                auction.setBeAuctionedAmount(beAuctioned.getBeAuctionedAmount());
                auction.setStatus("낙찰");
                auction.setProcGUBUN("S");
                auction.setBeAuctionedYnAuc("Y");
                auctionRepository.save(auction);
            });

            bidRepository.findByBidId((beAuctioned.getBidId())).ifPresent(bid->{
                bid.setBeAuctionedDate(beAuctioned.getBeAuctionedDate());
                bid.setBeAuctionedYN("Y");
                bidRepository.save(bid);
            });

        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucPaymentRegisted(@Payload AucPaymentRegistered aucPaymentRegistered){

        if(aucPaymentRegistered.isMe()){

            auctionRepository.findByAucId((aucPaymentRegistered.getAucId())).ifPresent(auction->{
                if(aucPaymentRegistered.getPaymentGubun().equals("END")){
                    auction.setStatus("판매종료");
                    auction.setProcGUBUN("E");
                    auction.setPaymentReqYN("E");
                }
                auctionRepository.save(auction);
            });

        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAucPaymentRegisted2(@Payload AucPaymentRegistered aucPaymentRegistered2){

        if(aucPaymentRegistered2.isMe()){

            bidRepository.findByBidId((aucPaymentRegistered2.getBidId())).ifPresent(bid->{
                bid.setStatus("판매종료");
                bidRepository.save(bid);
            });
        }
    }





}
