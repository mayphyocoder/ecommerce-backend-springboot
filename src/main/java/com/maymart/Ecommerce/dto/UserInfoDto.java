package com.maymart.Ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserInfoDto {
    private int id;
    private String name;
    private String email;
    private String password;
}
