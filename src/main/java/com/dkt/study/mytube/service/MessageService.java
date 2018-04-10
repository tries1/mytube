package com.dkt.study.mytube.service;

import com.dkt.study.mytube.model.Message;
import com.dkt.study.mytube.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Transactional
    public Message getMessage(Long id){
        return messageRepository.findById(id).orElse(new Message(0L, "not found"));
    }
}
