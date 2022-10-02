package com.isiris.ebayclone.service.mapper;

import com.isiris.ebayclone.repository.entities.auction.AuctionEntity;
import com.isiris.ebayclone.service.dto.AuctionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuctionMapper {
    AuctionDto toDto(AuctionEntity auctionEntity);

    AuctionEntity toEntity(AuctionDto auction);
}