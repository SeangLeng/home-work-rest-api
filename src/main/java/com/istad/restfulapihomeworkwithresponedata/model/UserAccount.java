package com.istad.restfulapihomeworkwithresponedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    private int userId;
    private String username;
    private String gender;
    private String profile;
    private int pin;
    private String passcode;
    private String phone_number;
    private int transfer_limit;
    private List<AccountTypes> account_Types;
}
