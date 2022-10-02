package com.isiris.ebayclone.repository;

import com.isiris.ebayclone.repository.entities.auction.AuctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, String>, JpaSpecificationExecutor<AuctionEntity> {
    Optional<AuctionEntity> findByIdAndSellerId(String id, String userId);
}
