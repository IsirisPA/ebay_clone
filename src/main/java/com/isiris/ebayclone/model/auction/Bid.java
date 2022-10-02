package com.isiris.ebayclone.model.auction;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Bid {
    private Bidder bidder;
    private LocalDateTime time;
    private Double amount;
}
