package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_topic", schema = "LEARN_ENGLISH_APP", catalog = "")
public class AccountTopic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "account_id")
    private Integer accountId;
    @Basic
    @Column(name = "topic_id")
    private Integer topicId;
    @Basic
    @Column(name = "status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account accountByAccountId;
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    private Topic topicByTopicId;

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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTopic that = (AccountTopic) o;
        return Objects.equals(id, that.id) && Objects.equals(accountId, that.accountId) && Objects.equals(topicId, that.topicId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, topicId, status);
    }

    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    public Topic getTopicByTopicId() {
        return topicByTopicId;
    }

    public void setTopicByTopicId(Topic topicByTopicId) {
        this.topicByTopicId = topicByTopicId;
    }
}
