package com.mattila.rabbitmq.repositories;

import com.mattila.rabbitmq.entities.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
