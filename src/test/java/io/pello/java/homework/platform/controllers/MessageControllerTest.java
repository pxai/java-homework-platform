package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.services.MessageService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MessageControllerTest {

    @Mock
    MessageService messageService;

    @Mock
    Model model;

    MessageController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new MessageController(messageService);
    }

    @Test
    public void getIndexPage() throws Exception {

        String viewName = controller.list(model);

        assertEquals("index", viewName);
        verify(messageService, times(1)).getMessages();
        verify(model, times(1)).addAttribute(eq("messages"), anySet());
    }

}