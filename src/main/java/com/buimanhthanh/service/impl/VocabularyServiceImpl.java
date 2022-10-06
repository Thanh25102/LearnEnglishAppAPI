package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.TopicDAO;
import com.buimanhthanh.dao.VocabularyDAO;
import com.buimanhthanh.dto.VocabularyDTO;
import com.buimanhthanh.entity.Topic;
import com.buimanhthanh.entity.Vocabulary;
import com.buimanhthanh.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VocabularyServiceImpl implements VocabularyService {

    @Autowired private VocabularyDAO vocabularyDAO;
    @Autowired private TopicDAO topicDAO;

    @Override
    public Optional<List<VocabularyDTO>> findAll() {
        return vocabularyDAO.findAll();
    }

    @Override
    public Optional<VocabularyDTO> findOne(Integer id) {
        return vocabularyDAO.findOne(id);
    }

    @Override
    public boolean saveOrUpdate(VocabularyDTO vocabularyDTO) {
        Topic topic = new Topic();
        topic.setId(vocabularyDTO.getTopicId());
        Vocabulary vocabulary = new Vocabulary(vocabularyDTO.getId(),vocabularyDTO.getVocabulary(),vocabularyDTO.getPhonetic(),vocabularyDTO.getMean(),vocabularyDTO.getAudio(),vocabularyDTO.getImage(),vocabularyDTO.getExampleSentences(),vocabularyDTO.getMeaningExp(),null,null);
        vocabulary.setTopicByTopicIdVocabulary(topic);
        return vocabularyDAO.saveOrUpdate(vocabulary);
    }

    @Override
    public void saveOrUpdate(List<Vocabulary> vocabularies) {
        vocabularyDAO.saveOrUpdate(vocabularies);
    }

    @Override
    public void delete(Integer id) {
        vocabularyDAO.delete(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        vocabularyDAO.delete(ids);
    }
}
