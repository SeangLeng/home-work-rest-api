package com.istad.restfulapihomeworkwithresponedata.service.serviceIMP;

import com.istad.restfulapihomeworkwithresponedata.model.UserAccount;
import com.istad.restfulapihomeworkwithresponedata.repository.UserAccountRepository;
import com.istad.restfulapihomeworkwithresponedata.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountIMPL implements UserAccountService {

    private final UserAccountRepository accountRepository;
    UserAccountIMPL(UserAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<UserAccount> getAllUserAccount() {
        return accountRepository.selectAllUserAccount();
    }

    @Override
    public List<UserAccount> getAllUserById(int id) {
        return accountRepository.getAllAccountTypeBYId(id);
    }

    @Override
    public int removeUserAccountById(int id) {
        return accountRepository.removeAccountById(id);
    }

    @Override
    public int updateUserAccountById(UserAccount account, int id) {
        return accountRepository.updateAccountById(account, id);
    }
}
