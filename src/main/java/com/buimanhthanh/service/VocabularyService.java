package com.buimanhthanh.service;

import com.buimanhthanh.dto.LessonDTO;
import com.buimanhthanh.dto.VocabularyDTO;
import com.buimanhthanh.entity.Lesson;
import com.buimanhthanh.entity.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface VocabularyService {
    Optional<List<VocabularyDTO>> findAll();
    Optional<VocabularyDTO> findOne(Integer id);
    boolean saveOrUpdate(VocabularyDTO vocabularyDTO);
    void saveOrUpdate(List<Vocabulary> vocabularies);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
