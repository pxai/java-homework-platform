package io.pello.java.homework.platform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.converters.MessageCommandToMessage;
import io.pello.java.homework.platform.converters.MessageToMessageCommand;
import io.pello.java.homework.platform.domain.Message;
import io.pello.java.homework.platform.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

	private MessageRepository messageRepository;
	private MessageToMessageCommand messageToMessageCommand;
	private MessageCommandToMessage messageCommandToMessage;
	
	
	
	public MessageServiceImpl(MessageRepository messageRepository, 
			MessageToMessageCommand messageToMessageCommand,
			MessageCommandToMessage messageCommandToMessage) {
		this.messageRepository = messageRepository;
		this.messageToMessageCommand = messageToMessageCommand;
		this.messageCommandToMessage = messageCommandToMessage;
	}

	@Override
	public Optional<Message> getById(Long id) {
		return messageRepository.findById(id);
	}
	
	@Override
	public List<Message> getMessages() {
		return (List<Message>)messageRepository.findAll();
	}

	@Override
	public MessageCommand saveMessage(MessageCommand messageCommand) {
		Message message = messageCommandToMessage.convert(messageCommand);
		Message savedMessage = messageRepository.save(message);
		
		return messageToMessageCommand.convert(savedMessage);
	}

}
