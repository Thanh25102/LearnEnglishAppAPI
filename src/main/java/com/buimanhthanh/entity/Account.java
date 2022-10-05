package com.buimanhthanh.entity;

import lombok.Data;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "account")
@Data
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

    @ManyToMany
    @JoinTable(name = "account_detail",joinColumns = @JoinColumn(name = "account_id"),
                inverseJoinColumns = @JoinColumn(name = "vocabulary_id"))
    private Set<Vocabulary> vocabularies;

    @ManyToMany
    @JoinTable(name="account_rank",joinColumns = @JoinColumn(name = "account_id"),
                inverseJoinColumns = @JoinColumn(name = "rank_id"))
    private Set<Rank> ranks;


    @ManyToMany
    @JoinTable(name = "account_topic",joinColumns = @JoinColumn(name = "account_id"),
                inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics;

}
