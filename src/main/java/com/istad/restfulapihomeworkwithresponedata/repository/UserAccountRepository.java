package com.istad.restfulapihomeworkwithresponedata.repository;

import com.istad.restfulapihomeworkwithresponedata.model.AccountTypes;
import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserAccountRepository {
    @Result(column = "account_types", property = "account_Types", one = @One(select = "getAllAccountTypeById"))
    @Select("SELECT * FROM user_account")
    List<UserAccount> selectAllUserAccount();

    @Select("SELECT * FROM account_types where id = #{id}")
    AccountTypes getAllAccountTypeById(int id);

    @Result(property = "accountTypes", column = "account_types",
            many = @Many(select = "com.istad.restfulapihomeworkwithresponedata.repository.getAllAccountTypes"))
    @Select("SELECT * " +
            "FROM account_types " +
            "         INNER JOIN user_account" +
            "                    ON account_types.#{id} = user_account.account_types")
    List<UserAccount> getAllAccountTypeBYId(int id);

    @Insert("insert into user_account(username, gender, profile, pin, passcode, phone_number, transfer_limit, account_types)" +
            "values (#{user.username}, #{user.gender}, #{user.profile}, #{user.pin}, #{user.passcode}, #{user.phone_number}, #{user.transfer_limit}, #{user.account_types})")
    int createNewUserAccount(@Param("user") UserAccount user);

    @Delete("DELETE FROM user_account WHERE userid = #{id}")
    int removeAccountById(@Param("id") int id);

    @Update("update user_account set username = #(account.username), gender = #(account.male), " +
            "profile = '#(account.profile), pin = #(account.pin), passcode = #(account.passcode), " +
            "phone_number = #(account.phone_number), transfer_limit = #(account.transfer_limit), " +
            "account_types = #(account.account_types) " +
            "where userid  = #(id);")
    int updateAccountById(@Param("account") UserAccount account, @Param("id") int id);
}
