package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.domain.Message;

public interface HomeworkService {
	public Optional<Message> getById(Long id);
	public List<Message> getMessages();
	public MessageCommand saveMessage(MessageCommand messageCommand);
}
