package io.pello.java.homework.platform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.pello.java.homework.platform.domain.Homework;


import java.util.List;

@Repository
public interface HomeworkRepository extends CrudRepository<Homework, Long> {
	List<Homework> findByTitle(String title);

}
