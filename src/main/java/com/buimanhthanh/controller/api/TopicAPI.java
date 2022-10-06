package com.buimanhthanh.controller.api;

import com.buimanhthanh.dto.ResponseObject;
import com.buimanhthanh.dto.TopicDTO;
import com.buimanhthanh.dto.VocabularyDTO;
import com.buimanhthanh.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicAPI {
    @Autowired private TopicService topicService;
    @GetMapping("")
    public ResponseEntity<ResponseObject> loadAllTopic(){
        List<TopicDTO> topics = topicService.findAll().get();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Query topics success", topics.size() == 0 ? "" : topics)
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> loadOneTopic(@PathVariable Integer id){
        Optional<TopicDTO> topicDTOOptional = topicService.findOne(id);
        return topicDTOOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query topic success",topicDTOOptional.get())
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Can not found topic with id : "+id,"")
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> addTopic(@RequestBody TopicDTO topicDTO){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert topic success",topicService.saveOrUpdate(topicDTO))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateTopic(@PathVariable Integer id,@RequestBody TopicDTO topicDTO){
        Optional<TopicDTO> topicOptional = topicService.findOne(id);
        return topicOptional.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Update topic success",topicService.saveOrUpdate(topicDTO))
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot found topic with id : "+id,false)
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteTopic(@PathVariable Integer id){
        topicService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Delete topic success",true)
        );
    }
}
