package com.buimanhthanh.service;

import com.buimanhthanh.dto.TopicDTO;
import com.buimanhthanh.dto.VocabularyDTO;
import com.buimanhthanh.entity.Vocabulary;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    Optional<List<TopicDTO>> findAll();
    Optional<TopicDTO> findOne(Integer id);
    boolean saveOrUpdate(TopicDTO topicDTO);
    void saveOrUpdate(List<TopicDTO> topicDTOs);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
