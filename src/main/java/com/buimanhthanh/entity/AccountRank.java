package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_rank", schema = "LEARN_ENGLISH_APP", catalog = "")
public class AccountRank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "account_id")
    private Integer accountId;
    @Basic
    @Column(name = "rank_id")
    private Integer rankId;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account accountByAccountId;
    @ManyToOne
    @JoinColumn(name = "rank_id", referencedColumnName = "id", nullable = false)
    private Rank rankByRankId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRank that = (AccountRank) o;
        return Objects.equals(id, that.id) && Objects.equals(accountId, that.accountId) && Objects.equals(rankId, that.rankId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, rankId);
    }

    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    public Rank getRankByRankId() {
        return rankByRankId;
    }

    public void setRankByRankId(Rank rankByRankId) {
        this.rankByRankId = rankByRankId;
    }
}
