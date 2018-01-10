package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.domain.Message;
import io.pello.java.homework.platform.services.MessageService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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

		assertEquals("messages/messages", viewName);
		verify(messageService, times(1)).getMessages();
		verify(model, times(1)).addAttribute(eq("messageCommand"), anySet());
	}

	@Test
	public void getIndexPage2() throws Exception {
		// given
		List<Message> messages = new ArrayList<Message>();
		messages.add(new Message());

		Message message = new Message();
		message.setId(1L);

		messages.add(message);

		when(messageService.getMessages()).thenReturn(messages);

		ArgumentCaptor<List<Message>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewName = controller.list(model);

		// then
		assertEquals("messages/messages", viewName);
		verify(messageService, times(1)).getMessages();
		verify(model, times(1)).addAttribute(eq("messageCommand"), argumentCaptor.capture());
		List<Message> listInController = argumentCaptor.getValue();
		assertEquals(2, listInController.size());
	}
}