package com.istad.restfulapihomeworkwithresponedata.controller;

import com.istad.restfulapihomeworkwithresponedata.map.UserAccountMapResponse;
import com.istad.restfulapihomeworkwithresponedata.model.ResponeUserAccount.ResponseUserAccount;
import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import com.istad.restfulapihomeworkwithresponedata.service.UserAccountService;
import com.istad.restfulapihomeworkwithresponedata.utils.Response;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
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

    @GetMapping("/remove-user-account/{id}")
    public Response<List<ResponseUserAccount>> removeUserAccount(@PathVariable("id") int id){
        try {
            int deletedRow = accountService.removeUserAccountById(id);
            if (deletedRow > 0){
                return Response.<List<ResponseUserAccount>>deleteSuccess().setMessage("Delete successes!");
            }else{
                return Response.<List<ResponseUserAccount>>notFound().setMessage("Id is not found!");
            }
        }catch (Exception e){
            System.out.println("Program got error: " + e.getMessage());
            return Response.<List<ResponseUserAccount>>exception().setMessage("Something went wrong!");
        }
    }

    @PutMapping("/update-user-account/{id}")
    public Response<List<ResponseUserAccount>> updateUserAccount(@RequestBody UserAccount account,
                                                                 @PathVariable("id") int id){
        try {
            int updateRowEffected = accountService.updateUserAccountById(account, id);
            if (updateRowEffected > 0){
                return Response.<List<ResponseUserAccount>>ok().setMessage("Update Successfully!");
            }else{
                return Response.<List<ResponseUserAccount>>notFound().setMessage("update is not success!");
            }
        }catch (Exception e){
            System.out.println("Error happened : " + e.getMessage());
            return Response.<List<ResponseUserAccount>>notFound().setMessage("something went wrong!");
        }
    }
}