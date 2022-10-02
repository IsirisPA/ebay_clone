package com.isiris.ebayclone.service;

import com.isiris.ebayclone.service.dto.AuctionDto;

public interface AuctionService {
    AuctionDto getAuction(String auctionId);

    String postAuction(AuctionDto auction);

    void deleteAuction(String auctionId, String userId);

    String editAuction(String auctionId, AuctionDto auction);

    String startAuction(String auctionId, String userId);

    Boolean checkAuctionOpen(String auctionId);

    byte[] downloadAuctionData(String auctionId, Boolean isJson);
}
