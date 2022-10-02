package com.isiris.ebayclone.model.auction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Location {
    private String longitude;
    private String latitude;
}
