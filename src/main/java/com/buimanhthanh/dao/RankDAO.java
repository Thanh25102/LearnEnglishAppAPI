package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RankDAO {
    Optional<List<Rank>> findAll();
    Optional<Rank> findOne(Integer id);
    void saveOrUpdate(Rank rank);
    void saveOrUpdate(List<Rank> ranks);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
