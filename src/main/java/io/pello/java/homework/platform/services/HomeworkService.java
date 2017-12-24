package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import io.pello.java.homework.platform.commands.HomeworkCommand;
import io.pello.java.homework.platform.domain.Homework;

public interface HomeworkService {
	public Optional<Homework> getById(Long id);
	public List<Homework> getHomeworks();
	public HomeworkCommand saveHomework(HomeworkCommand homeworkCommand);
}
