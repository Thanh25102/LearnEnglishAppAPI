package com.buimanhthanh.dao;

import com.buimanhthanh.entity.Topic;
import com.buimanhthanh.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface VocabularyDAO {
    Optional<List<Vocabulary>> findAll();
    Optional<Vocabulary> findOne(Integer id);
    void saveOrUpdate(Vocabulary vocabulary);
    void saveOrUpdate(List<Vocabulary> vocabularys);
    void delete(Integer id);
    void delete(List<Vocabulary> ids);
}
