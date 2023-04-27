package com.istad.restfulapihomeworkwithresponedata.map;

import com.istad.restfulapihomeworkwithresponedata.model.ResponeUserAccount.ResponseUserAccount;
import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAccountMapResponse {

    // account -> account-response
    List<ResponseUserAccount> mapToUserAccount(List<UserAccount> accounts);
    // account-response -> account
    List<UserAccount> mapBackToResponse(List<ResponseUserAccount> responses);

}
