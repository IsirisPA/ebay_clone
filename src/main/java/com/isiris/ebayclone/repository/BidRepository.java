package com.isiris.ebayclone.repository;


import com.isiris.ebayclone.repository.entities.auction.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, String>, JpaSpecificationExecutor<BidEntity> {
}
