package io.pello.java.homework.platform.commands;

import java.util.Date;

import io.pello.java.homework.platform.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AssignmentCommand {
	private Long id;
	private String name;
	private String description;
	private Date start;
    private Date due;
	private User user;
}