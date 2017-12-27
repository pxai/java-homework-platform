package io.pello.java.homework.platform.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.pello.java.homework.platform.commands.AssignmentCommand;
import io.pello.java.homework.platform.domain.Assignment;

@Component
public class AssignmentToAssignmentCommand implements Converter<Assignment, AssignmentCommand> {

    @Synchronized
    @Nullable
    @Override
    public AssignmentCommand convert(Assignment assignment) {
        if (assignment == null) {
            return null;
        }

        final AssignmentCommand assignmentCommand = new AssignmentCommand();

        assignmentCommand.setId(assignment.getId());
        assignmentCommand.setName(assignment.getName());
        assignmentCommand.setDescription(assignment.getDescription());

        return assignmentCommand;
    }
}