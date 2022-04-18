package com.example.auction.domain.repository;

import com.example.auction.domain.Beauction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="beauctions", path="beauctions")
public interface BeauctionRepository extends PagingAndSortingRepository<Beauction, Long>{
    Optional<Beauction> findByAucId(Long aucId);

}
