package com.istad.restfulapihomeworkwithresponedata.repository;

import com.istad.restfulapihomeworkwithresponedata.model.AccountTypes;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface accountTypesRepository {

    @Select("SELECT * FROM account_types where id = #{account_types}")
    AccountTypes getAllAccountTypes(int account_types);
}
