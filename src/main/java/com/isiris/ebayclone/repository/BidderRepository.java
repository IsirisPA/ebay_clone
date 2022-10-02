package com.isiris.ebayclone.repository;

import com.isiris.ebayclone.repository.entities.auction.BidderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BidderRepository extends JpaRepository<BidderEntity, String>, JpaSpecificationExecutor<BidderEntity> {
}
