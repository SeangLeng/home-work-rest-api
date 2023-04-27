package com.istad.restfulapihomeworkwithresponedata.repository;

import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountRepository {
    @Select("SELECT * FROM user_account")
    List<UserAccount> selectAllUserAccount();

    @Result(property = "accountTypes", column = "account_types",
            many = @Many(select = "com.istad.restfulapihomeworkwithresponedata.repository.getAllAccountTypes"))
    @Select("SELECT *" +
            "FROM user_account" +
            "         INNER JOIN account_types" +
            "                    ON user_account.account_types = account_types.#{id};")
    List<UserAccount> getAllAccountTypeBYId(int id);
}
