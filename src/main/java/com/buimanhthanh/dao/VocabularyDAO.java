package com.buimanhthanh.dao;

import com.buimanhthanh.dto.VocabularyDTO;
import com.buimanhthanh.entity.Topic;
import com.buimanhthanh.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface VocabularyDAO {
    Optional<List<VocabularyDTO>> findAll();
    Optional<VocabularyDTO> findOne(Integer id);
    boolean saveOrUpdate(Vocabulary vocabulary);
    void saveOrUpdate(List<Vocabulary> vocabularies);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
