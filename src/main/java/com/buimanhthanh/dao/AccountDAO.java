package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    Optional<List<Account>> findAll();
    Optional<Account> findOne(Integer id);
    boolean saveOrUpdate(Account account);
    void saveOrUpdate(List<Account> accounts);
    void delete(Integer id);
    void delete(List<Integer> ids);
}