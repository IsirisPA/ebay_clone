package com.isiris.ebayclone.service.mapper;

import com.isiris.ebayclone.repository.entities.auction.BidEntity;
import com.isiris.ebayclone.service.dto.BidDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidMapper {
    BidEntity toEntity(BidDto bidDto);

    BidDto toDto(BidEntity bidEntity);

    List<BidDto> toDto(List<BidEntity> bidEntity);
}
