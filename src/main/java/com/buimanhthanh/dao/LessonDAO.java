package com.buimanhthanh.dao;

import com.buimanhthanh.dto.LessonDTO;
import com.buimanhthanh.entity.Lesson;
import com.buimanhthanh.entity.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface LessonDAO {
    Optional<List<LessonDTO>> findAll();
    Optional<LessonDTO> findOne(Integer id);
    boolean saveOrUpdate(Lesson lesson);
    void saveOrUpdate(List<Lesson> lessons);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
