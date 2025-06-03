package com.gustavo.test_omnichannel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.test_omnichannel.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
       
}
