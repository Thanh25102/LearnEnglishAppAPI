package com.buimanhthanh.dao;

import com.buimanhthanh.dto.TopicDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TopicDAO {
    Optional<List<TopicDTO>> findAll();
    Optional<TopicDTO> findOne(Integer id);
    boolean saveOrUpdate(Topic topic);
    void saveOrUpdate(List<Topic> topics);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
