package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vocabulary {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "vocabulary")
    private String vocabulary;
    @Basic
    @Column(name = "mean")
    private String mean;
    @Basic
    @Column(name = "audio")
    private String audio;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "example_sentences")
    private String exampleSentences;
    @Basic
    @Column(name = "meaning_exp")
    private String meaningExp;
    @Basic
    @Column(name = "topic_id")
    private Integer topicId;
    @OneToMany(mappedBy = "vocabularyByVocabularyId")
    private Collection<AccountDetail> accountDetailsById;
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    private Topic topicByTopicId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExampleSentences() {
        return exampleSentences;
    }

    public void setExampleSentences(String exampleSentences) {
        this.exampleSentences = exampleSentences;
    }

    public String getMeaningExp() {
        return meaningExp;
    }

    public void setMeaningExp(String meaningExp) {
        this.meaningExp = meaningExp;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary that = (Vocabulary) o;
        return Objects.equals(id, that.id) && Objects.equals(vocabulary, that.vocabulary) && Objects.equals(mean, that.mean) && Objects.equals(audio, that.audio) && Objects.equals(image, that.image) && Objects.equals(exampleSentences, that.exampleSentences) && Objects.equals(meaningExp, that.meaningExp) && Objects.equals(topicId, that.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vocabulary, mean, audio, image, exampleSentences, meaningExp, topicId);
    }

    public Collection<AccountDetail> getAccountDetailsById() {
        return accountDetailsById;
    }

    public void setAccountDetailsById(Collection<AccountDetail> accountDetailsById) {
        this.accountDetailsById = accountDetailsById;
    }

    public Topic getTopicByTopicId() {
        return topicByTopicId;
    }

    public void setTopicByTopicId(Topic topicByTopicId) {
        this.topicByTopicId = topicByTopicId;
    }
}
