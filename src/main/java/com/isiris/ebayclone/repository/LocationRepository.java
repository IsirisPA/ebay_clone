package com.isiris.ebayclone.repository;

import com.isiris.ebayclone.repository.entities.auction.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, String>, JpaSpecificationExecutor<LocationEntity> {
}
