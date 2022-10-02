package com.isiris.ebayclone.service;

import com.isiris.ebayclone.service.dto.BidDto;

import java.util.List;

public interface BidService {
    String bidToAuction(String auctionId, BidDto bidDto);

    List<BidDto> getBidsOfAuction(String auctionId);

    BidDto getBidOfAuction(String bidId);
}
