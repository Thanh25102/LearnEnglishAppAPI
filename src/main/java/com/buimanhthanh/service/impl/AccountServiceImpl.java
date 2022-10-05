package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.AccountDAO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.service.AccountService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Optional<List<Account>> findAll() {
        return accountDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Account> findOne(Integer id) {
        return accountDAO.findOne(id);
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(Account account) {
        return accountDAO.saveOrUpdate(account);
    }

    @Override
    @Transactional
    public void saveOrUpdate(List<Account> accounts) {
        accountDAO.saveOrUpdate(accounts);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        accountDAO.delete(id);
    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {
        accountDAO.delete(ids);
    }
}
