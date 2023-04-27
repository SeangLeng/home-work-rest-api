package com.istad.restfulapihomeworkwithresponedata.controller;

import com.istad.restfulapihomeworkwithresponedata.map.UserAccountMapResponse;
import com.istad.restfulapihomeworkwithresponedata.model.ResponeUserAccount.ResponseUserAccount;
import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import com.istad.restfulapihomeworkwithresponedata.service.UserAccountService;
import com.istad.restfulapihomeworkwithresponedata.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {
    private final UserAccountMapResponse userAccountMapResponse;
    private final UserAccountService accountService;

    UserAccountController(UserAccountService userAccountService, UserAccountMapResponse userAccountMapResponse){
        this.accountService = userAccountService;
        this.userAccountMapResponse = userAccountMapResponse;
    }

    @GetMapping("/all-user-account")
    public Response<List<ResponseUserAccount>> getAllUserAccount(){
        try {
            List<UserAccount> getAllUserAccount = accountService.getAllUserAccount();
            List<ResponseUserAccount> userAccountResponse = userAccountMapResponse.mapToUserAccount(getAllUserAccount);
            return Response.<List<ResponseUserAccount>>ok().setPayload(userAccountResponse).setMessage("successfully retrieved all user account information");
        }catch (Exception e){
            System.out.println("Wrong : " + e.getMessage());
            return Response.<List<ResponseUserAccount>>exception().setMessage("Try to access to all user account info again later");
        }
    }
}
