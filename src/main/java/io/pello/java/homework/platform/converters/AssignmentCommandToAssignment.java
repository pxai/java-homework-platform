package io.pello.java.homework.platform.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.pello.java.homework.platform.commands.AssignmentCommand;
import io.pello.java.homework.platform.domain.Assignment;


@Component
public class AssignmentCommandToAssignment 
		implements Converter<AssignmentCommand, Assignment>{

    @Synchronized
    @Nullable
    @Override
	public Assignment convert(AssignmentCommand assignmentCommand) {
        if (assignmentCommand == null) {
            return null;
        }

        final Assignment assignment = new Assignment();
        assignment.setId(assignmentCommand.getId());
        assignment.setName(assignmentCommand.getName());
        assignment.setDescription(assignmentCommand.getDescription());
        return assignment;
	}
}