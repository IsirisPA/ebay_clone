package com.isiris.ebayclone.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String email;
    private String username;
    private String password;
    private Boolean isApproved;
    private Address address;
    private String phone;
}
