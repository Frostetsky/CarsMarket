package com.carmarket.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpDto {

    private String username;

    private String password;
}
