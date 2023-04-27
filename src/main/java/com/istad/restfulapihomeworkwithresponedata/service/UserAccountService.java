package com.istad.restfulapihomeworkwithresponedata.service;

import com.istad.restfulapihomeworkwithresponedata.model.AccountTypes;
import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import org.apache.catalina.User;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> getAllUserAccount();
    List<UserAccount> getAllUserById(int id);
    int removeUserAccountById(int id);
    int updateUserAccountById(UserAccount account, int id);
}
