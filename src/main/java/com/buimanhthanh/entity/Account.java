package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<AccountDetail> accountDetailsById;
    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<AccountRank> accountRanksById;
    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<AccountTopic> accountTopicsById;

    public Account( String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(fullName, account.fullName) && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullName, email);
    }

    public Collection<AccountDetail> getAccountDetailsById() {
        return accountDetailsById;
    }

    public void setAccountDetailsById(Collection<AccountDetail> accountDetailsById) {
        this.accountDetailsById = accountDetailsById;
    }

    public Collection<AccountRank> getAccountRanksById() {
        return accountRanksById;
    }

    public void setAccountRanksById(Collection<AccountRank> accountRanksById) {
        this.accountRanksById = accountRanksById;
    }

    public Collection<AccountTopic> getAccountTopicsById() {
        return accountTopicsById;
    }

    public void setAccountTopicsById(Collection<AccountTopic> accountTopicsById) {
        this.accountTopicsById = accountTopicsById;
    }
}
