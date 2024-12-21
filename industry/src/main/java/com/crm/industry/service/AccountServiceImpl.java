package com.crm.industry.service;

import com.crm.industry.model.Account;
import com.crm.industry.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        boolean isValid = validate(account);
        if (isValid) {
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    private boolean validate(Account account) {
        if (account.getName() == null || account.getType() == null) {
            System.out.println("Account name or type is empty");
            return false;
        }

        return true;
    }

    @Override
    public Account update(Account account, String id) {
        if (account != null && id != null) {
            account.setId(id);
            accountRepository.save(account);
        }
        return account;
    }

    @Cacheable(value = "GET_ACCOUNT", key = "id")
    @Override
    public Account get(String id) {
        if (id != null) {
            Optional<Account> account = accountRepository.findById(id);
            if (account.isPresent()) {
                return account.get();
            }
        }
        return null;
    }

    @Override
    public List<Account> get() throws Exception {
        try {
            List<Account> accounts = accountRepository.findAll();
            if (accounts.isEmpty()) {
                return null;
            }
            return accounts;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void delete(String id) {
        if (id != null) {
            accountRepository.deleteById(id);

        }
    }
}

