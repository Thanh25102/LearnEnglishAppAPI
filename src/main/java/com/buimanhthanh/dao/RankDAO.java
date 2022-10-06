package com.buimanhthanh.dao;

import com.buimanhthanh.dto.RankDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RankDAO {
    Optional<List<RankDTO>> findAll();
    Optional<RankDTO> findOne(Integer id);
    boolean saveOrUpdate(Rank rank);
    void saveOrUpdate(List<Rank> ranks);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
