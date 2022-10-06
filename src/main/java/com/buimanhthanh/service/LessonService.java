package com.buimanhthanh.service;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.LessonDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    Optional<List<LessonDTO>> findAll();
    Optional<LessonDTO> findOne(Integer id);
    boolean saveOrUpdate(Lesson lesson);
    void saveOrUpdate(List<Lesson> lessons);
    void delete(Integer id);
    void delete(List<Integer> ids);
}
