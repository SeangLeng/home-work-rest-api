package com.istad.restfulapihomeworkwithresponedata.model.ResponeUserAccount;

import com.istad.restfulapihomeworkwithresponedata.model.AccountTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserAccount {
    private int userId;
    private String username;
    private String gender;
    private String profile;
    private String phone_number;
    private int transfer_limit;
    private List<AccountTypes> account_Types;
}
