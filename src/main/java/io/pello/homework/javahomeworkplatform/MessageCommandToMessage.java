package io.pello.homework.javahomeworkplatform;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

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