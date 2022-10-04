package com.buimanhthanh.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "repersent")
    private String repersent;
    @Basic
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "rankByRankId")
    private Collection<AccountRank> accountRanksById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepersent() {
        return repersent;
    }

    public void setRepersent(String repersent) {
        this.repersent = repersent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(id, rank.id) && Objects.equals(name, rank.name) && Objects.equals(description, rank.description) && Objects.equals(repersent, rank.repersent) && Objects.equals(type, rank.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, repersent, type);
    }

    public Collection<AccountRank> getAccountRanksById() {
        return accountRanksById;
    }

    public void setAccountRanksById(Collection<AccountRank> accountRanksById) {
        this.accountRanksById = accountRanksById;
    }
}
