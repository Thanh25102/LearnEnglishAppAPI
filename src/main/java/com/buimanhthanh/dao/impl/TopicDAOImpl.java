package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.TopicDAO;
import com.buimanhthanh.dto.TopicDTO;
import com.buimanhthanh.entity.Topic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TopicDAOImpl implements TopicDAO {
    @Autowired private SessionFactory session;
    @Override
    public Optional<List<Topic>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<TopicDTO> findOne(Integer id) {
        return session.getCurrentSession().createQuery("select new com.buimanhthanh.dto.TopicDTO(t.id,t.represent,t.description,t.descriptiveMeaning) from Topic t", TopicDTO.class)
                        .stream().findFirst();
    }

    @Override
    public void saveOrUpdate(Topic topic) {

    }

    @Override
    public void saveOrUpdate(List<Topic> topics) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(List<Integer> ids) {

    }
}
