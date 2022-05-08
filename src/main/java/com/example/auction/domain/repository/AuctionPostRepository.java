package com.example.auction.domain.repository;

import com.example.auction.domain.Auction;
import com.example.auction.domain.AuctionPost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="auctionposts", path="auctionposts")
public interface AuctionPostRepository extends PagingAndSortingRepository<AuctionPost, Long>{
    Optional<Auction> findByPostId(Long postId);
    List<Auction> findByAucPostId(Long aucPostId);
}
