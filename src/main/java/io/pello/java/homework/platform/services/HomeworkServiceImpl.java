package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.pello.java.homework.platform.commands.HomeworkCommand;
import io.pello.java.homework.platform.converters.HomeworkCommandToHomework;
import io.pello.java.homework.platform.converters.HomeworkToHomeworkCommand;
import io.pello.java.homework.platform.domain.Homework;
import io.pello.java.homework.platform.repositories.HomeworkRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HomeworkServiceImpl implements HomeworkService {

	private HomeworkRepository homeworkRepository;
	private HomeworkToHomeworkCommand homeworkToHomeworkCommand;
	private HomeworkCommandToHomework homeworkCommandToHomework;
	
	
	
	public HomeworkServiceImpl(HomeworkRepository homeworkRepository, 
			HomeworkToHomeworkCommand homeworkToHomeworkCommand,
			HomeworkCommandToHomework homeworkCommandToHomework) {
		this.homeworkRepository = homeworkRepository;
		this.homeworkToHomeworkCommand = homeworkToHomeworkCommand;
		this.homeworkCommandToHomework = homeworkCommandToHomework;
	}

	@Override
	public Optional<Homework> getById(Long id) {
		return homeworkRepository.findById(id);
	}
	
	@Override
	public List<Homework> getHomeworks() {
		return (List<Homework>)homeworkRepository.findAll();
	}

	@Override
	public HomeworkCommand saveHomework(HomeworkCommand homeworkCommand) {
		Homework homework = homeworkCommandToHomework.convert(homeworkCommand);
		Homework savedHomework = homeworkRepository.save(homework);
		
		return homeworkToHomeworkCommand.convert(savedHomework);
	}

}
