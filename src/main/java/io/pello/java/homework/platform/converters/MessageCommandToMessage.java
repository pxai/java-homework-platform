package io.pello.java.homework.platform.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.pello.java.homework.platform.commands.MessageCommand;
import io.pello.java.homework.platform.domain.Message;

@Component
public class MessageCommandToMessage 
		implements Converter<MessageCommand, Message>{

    @Synchronized
    @Nullable
    @Override
	public Message convert(MessageCommand messageCommand) {
        if (messageCommand == null) {
            return null;
        }

        final Message message = new Message();
        message.setId(messageCommand.getId());
        message.setTitle(messageCommand.getTitle());
        message.setContent(messageCommand.getContent());
        return message;
	}
}