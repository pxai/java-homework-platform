package io.pello.homework.javahomeworkplatform;

import java.util.List;
import java.util.Optional;

public interface MessageService {
	public Optional<Message> getById(Long id);
	public List<Message> getMessages();
	public MessageCommand saveMessage(MessageCommand messageCommand);
}
