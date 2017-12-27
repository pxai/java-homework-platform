package io.pello.java.homework.platform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.pello.java.homework.platform.domain.Assignment;
import java.util.List;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	List<Assignment> findByName(String name);

}
