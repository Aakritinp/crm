package com.crm.industry.controller;

import com.crm.industry.model.Account;
import com.crm.industry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping()
    public Account save(@RequestBody Account account) {
        Account newAccount = accountService.save(account);
        return newAccount;
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable String id, @RequestBody Account account) {
        Account newAccount = accountService.update(account, id);
        return newAccount;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        Account newAccount = accountService.get(id);
        if(newAccount!=null){
            return ResponseEntity.ok(newAccount);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping()
    public List<Account> get(){
        List<Account> newAccount = accountService.get();
        return newAccount;
    }

    @DeleteMapping
    public void delete(@PathVariable String id){
        accountService.delete(id);

    }
}

