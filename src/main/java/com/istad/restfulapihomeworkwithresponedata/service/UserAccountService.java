package com.istad.restfulapihomeworkwithresponedata.service;

import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> getAllUserAccount();
    List<UserAccount> getAllUserById(int id);
}
