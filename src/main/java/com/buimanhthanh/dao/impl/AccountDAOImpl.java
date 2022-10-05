package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.AccountDAO;
import com.buimanhthanh.entity.Account;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory session;

    @Override
    public Optional<List<Account>> findAll() {
//        CriteriaBuilder cb = session.getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
//        Root<Account> rootEntry = cq.from(Account.class);
//        CriteriaQuery<Account> all = cq.select(rootEntry);
//
//        TypedQuery<Account> allQuery = session.getCurrentSession().createQuery(all);
//        return Optional.ofNullable(allQuery.getResultList());
        return Optional.ofNullable(session.getCurrentSession().createQuery("from Account",Account.class)
                .getResultList());
    }

    @Override
    public Optional<Account> findOne(Integer id) {
        return session.getCurrentSession().createQuery("select a from Account as a where a.id =: i",Account.class)
                .setParameter("i",id).getResultList().stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Account account) {
        try {
            session.getCurrentSession().saveOrUpdate(account);
            return true;
        }catch (HibernateException e){
            System.out.println("ERROR WHEN ADD ACCOUNT : " + e.getMessage());
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Account> accounts) {
        accounts.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        session.getCurrentSession().delete(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
