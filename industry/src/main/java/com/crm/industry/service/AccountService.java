package com.crm.industry.service;

import com.crm.industry.model.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    Account update(Account account, String id);

    Account get(String id);

    List<Account> get();

    void delete(String id);
}
