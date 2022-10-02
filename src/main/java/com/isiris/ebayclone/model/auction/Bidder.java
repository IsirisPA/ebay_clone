package com.isiris.ebayclone.model.auction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Bidder {
    private String userId;
    private Integer rating;
}
