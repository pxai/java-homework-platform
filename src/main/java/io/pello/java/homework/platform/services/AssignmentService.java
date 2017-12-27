package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import io.pello.java.homework.platform.commands.AssignmentCommand;
import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.domain.Assignment;
import io.pello.java.homework.platform.domain.Message;

public interface AssignmentService {
	public Optional<Assignment> getById(Long id);
	public List<Assignment> getAssignments();
	public AssignmentCommand saveAssignment(AssignmentCommand assignmentCommand);
}
