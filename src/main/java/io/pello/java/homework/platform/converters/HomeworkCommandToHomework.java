package io.pello.java.homework.platform.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.pello.java.homework.platform.commands.HomeworkCommand;
import io.pello.java.homework.platform.domain.Homework;

@Component
public class HomeworkCommandToHomework 
		implements Converter<HomeworkCommand, Homework>{

    @Synchronized
    @Nullable
    @Override
	public Homework convert(HomeworkCommand homeworkCommand) {
        if (homeworkCommand == null) {
            return null;
        }

        final Homework homework = new Homework();
        homework.setId(homeworkCommand.getId());
        homework.setTitle(homeworkCommand.getTitle());
        homework.setDescription(homeworkCommand.getDescription());
        return homework;
	}
}