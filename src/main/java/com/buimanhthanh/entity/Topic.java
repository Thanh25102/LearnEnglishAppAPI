package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Topic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "represent")
    private String represent;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "descriptive_meaning")
    private String descriptiveMeaning;
    @Basic
    @Column(name = "lesson_id")
    private Integer lessonId;
    @OneToMany(mappedBy = "topicByTopicId")
    private Collection<AccountTopic> accountTopicsById;
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    private Lesson lessonByLessonId;
    @OneToMany(mappedBy = "topicByTopicId")
    private Collection<Vocabulary> vocabulariesById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptiveMeaning() {
        return descriptiveMeaning;
    }

    public void setDescriptiveMeaning(String descriptiveMeaning) {
        this.descriptiveMeaning = descriptiveMeaning;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id) && Objects.equals(represent, topic.represent) && Objects.equals(description, topic.description) && Objects.equals(descriptiveMeaning, topic.descriptiveMeaning) && Objects.equals(lessonId, topic.lessonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, represent, description, descriptiveMeaning, lessonId);
    }

    public Collection<AccountTopic> getAccountTopicsById() {
        return accountTopicsById;
    }

    public void setAccountTopicsById(Collection<AccountTopic> accountTopicsById) {
        this.accountTopicsById = accountTopicsById;
    }

    public Lesson getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(Lesson lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }

    public Collection<Vocabulary> getVocabulariesById() {
        return vocabulariesById;
    }

    public void setVocabulariesById(Collection<Vocabulary> vocabulariesById) {
        this.vocabulariesById = vocabulariesById;
    }
}
