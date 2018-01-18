package io.pello.java.homework.platform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.pello.java.homework.platform.domain.Message;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findByTitle(String title);
	List<Message> findByContent(String content);
}
