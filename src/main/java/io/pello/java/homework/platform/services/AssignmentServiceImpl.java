package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.pello.java.homework.platform.commands.AssignmentCommand;
import io.pello.java.homework.platform.converters.AssignmentCommandToAssignment;
import io.pello.java.homework.platform.converters.AssignmentToAssignmentCommand;
import io.pello.java.homework.platform.domain.Assignment;
import io.pello.java.homework.platform.repositories.AssignmentRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AssignmentServiceImpl implements AssignmentService {

	private AssignmentRepository assignmentRepository;
	private AssignmentToAssignmentCommand assignmentToAssignmentCommand;
	private AssignmentCommandToAssignment assignmentCommandToAssignment;
	
	
	
	public AssignmentServiceImpl(AssignmentRepository assignmentRepository, 
			AssignmentToAssignmentCommand assignmentToAssignmentCommand,
			AssignmentCommandToAssignment assignmentCommandToAssignment) {
		this.assignmentRepository = assignmentRepository;
		this.assignmentToAssignmentCommand = assignmentToAssignmentCommand;
		this.assignmentCommandToAssignment = assignmentCommandToAssignment;
	}

	@Override
	public Optional<Assignment> getById(Long id) {
		return assignmentRepository.findById(id);
	}
	
	@Override
	public List<Assignment> getAssignments() {
		return (List<Assignment>)assignmentRepository.findAll();
	}

	@Override
	public AssignmentCommand saveAssignment(AssignmentCommand assignmentCommand) {
		Assignment assignment = assignmentCommandToAssignment.convert(assignmentCommand);
		Assignment savedAssignment = assignmentRepository.save(assignment);
		
		return assignmentToAssignmentCommand.convert(savedAssignment);
	}

}
