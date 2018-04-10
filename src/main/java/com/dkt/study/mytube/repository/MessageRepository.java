package com.dkt.study.mytube.repository;

import com.dkt.study.mytube.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;

//ReactiveCrudRepository
public interface MessageRepository extends JpaRepository<Message, Long> {
    //MessageTest findById(Long id);
}
