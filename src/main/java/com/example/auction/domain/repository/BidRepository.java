package com.example.auction.domain.repository;

import com.example.auction.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="bids", path="bids")
public interface BidRepository extends JpaRepository<Bid, Long> {
    Optional<Bid> findByAucId(Long aucId);
    Optional<Bid> findByBidId(Long bidId);

}
