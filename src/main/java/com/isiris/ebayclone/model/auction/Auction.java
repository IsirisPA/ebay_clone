package com.isiris.ebayclone.model.auction;

import com.isiris.ebayclone.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Auction {
    private String name;
    private Category category;
    private Double currently;
    private Double buyPrice;
    private Double firstBid;
    private Integer numberOfBids;
    private List<Bid> bids;
    private Location location;
    private String country;
    private Integer started;
    private Integer ends;
    private User seller;
    private String description;
}
