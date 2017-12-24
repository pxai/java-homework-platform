package io.pello.java.homework.platform.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.pello.java.homework.platform.commands.HomeworkCommand;
import io.pello.java.homework.platform.domain.Homework;

@Component
public class HomeworkToHomeworkCommand implements Converter<Homework, HomeworkCommand> {

    @Synchronized
    @Nullable
    @Override
    public HomeworkCommand convert(Homework homework) {
        if (homework == null) {
            return null;
        }

        final HomeworkCommand homeworkCommand = new HomeworkCommand();

        homeworkCommand.setId(homework.getId());
        homeworkCommand.setTitle(homework.getTitle());
        homeworkCommand.setDescription(homework.getDescription());

        return homeworkCommand;
    }
}