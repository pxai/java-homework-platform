package io.pello.java.homework.platform.commands;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class HomeworkCommand {
    private Long id;
    private String title;
    private String description;
}