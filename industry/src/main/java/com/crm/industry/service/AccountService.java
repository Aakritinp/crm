package com.crm.industry.service;

import com.crm.industry.model.Account;

public interface AccountService {

    Account save(Account account);

    Account update(Account account, String id);

    Account get(String id);

    void delete(String id);
}
