package com.buimanhthanh.controller.api;

import com.buimanhthanh.entity.Account;
import com.buimanhthanh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountAPI {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public List<Account> loadAccount(){
        System.out.println(accountService.findAll().get().toString());
        return accountService.findAll().get();
    }

    @GetMapping("/{id}")
    public Account loadOneAccount(@PathVariable Integer id){
        return accountService.findOne(id).get();
    }

    @PostMapping()
    public Boolean addAccount(@RequestBody Account account){
        return accountService.saveOrUpdate(account);
    }


}
