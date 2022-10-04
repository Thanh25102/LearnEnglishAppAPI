package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_detail", schema = "LEARN_ENGLISH_APP", catalog = "")
public class AccountDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "account_id")
    private Integer accountId;
    @Basic
    @Column(name = "vocabulary_id")
    private Integer vocabularyId;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account accountByAccountId;
    @ManyToOne
    @JoinColumn(name = "vocabulary_id", referencedColumnName = "id", nullable = false)
    private Vocabulary vocabularyByVocabularyId;

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

    public Integer getVocabularyId() {
        return vocabularyId;
    }

    public void setVocabularyId(Integer vocabularyId) {
        this.vocabularyId = vocabularyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDetail that = (AccountDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(accountId, that.accountId) && Objects.equals(vocabularyId, that.vocabularyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, vocabularyId);
    }

    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    public Vocabulary getVocabularyByVocabularyId() {
        return vocabularyByVocabularyId;
    }

    public void setVocabularyByVocabularyId(Vocabulary vocabularyByVocabularyId) {
        this.vocabularyByVocabularyId = vocabularyByVocabularyId;
    }
}
