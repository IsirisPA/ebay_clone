package com.isiris.ebayclone.service.impl;

import com.isiris.ebayclone.repository.AuctionRepository;
import com.isiris.ebayclone.repository.BidRepository;
import com.isiris.ebayclone.service.BidService;
import com.isiris.ebayclone.service.dto.BidDto;
import com.isiris.ebayclone.service.mapper.BidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;
    private final BidMapper bidMapper;

    public String bidToAuction(String auctionId, BidDto bid) {
        return auctionRepository.findById(auctionId).map(auctionEntity -> {
            auctionEntity.getBids().add(bidMapper.toEntity(bid));
            return auctionRepository.save(auctionEntity).getId();
        }).orElseThrow(RuntimeException::new);
    }

    public List<BidDto> getBidsOfAuction(String auctionId) {
        return auctionRepository.findById(auctionId).map(auctionEntity ->
                bidMapper.toDto(auctionEntity.getBids())).orElseThrow(RuntimeException::new);
    }

    @Override
    public BidDto getBidOfAuction(String bidId) {
        return bidRepository.findById(bidId).map(bidMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }
}
