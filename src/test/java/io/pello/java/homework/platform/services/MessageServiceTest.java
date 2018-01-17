package io.pello.java.homework.platform.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import io.pello.java.homework.platform.converters.MessageCommandToMessage;
import io.pello.java.homework.platform.converters.MessageToMessageCommand;
import io.pello.java.homework.platform.domain.Message;
import io.pello.java.homework.platform.repositories.MessageRepository;


public class MessageServiceTest {

    private MessageServiceImpl messageService;
    @Autowired
    private MessageToMessageCommand messageToMessageCommand;
    @Autowired
    private MessageCommandToMessage messageCommandToMessage;
    
    @Mock
    private MessageRepository messageRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        messageService = new MessageServiceImpl(messageRepository, messageToMessageCommand, messageCommandToMessage);
    }

    @Test
    public void getMessages() throws Exception {
        List<Message> messageData = new ArrayList<Message>();
        messageData.add(new Message());
        messageData.add(new Message());
        
        when(messageService.getMessages()).thenReturn(messageData);

        List<Message> messages = messageService.getMessages();

        assertEquals(messages.size(), 2);
        verify(messageRepository, times(1)).findAll();
    }

}