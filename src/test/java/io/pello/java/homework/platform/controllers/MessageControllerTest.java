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
	List<Message> messages;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		messages = new ArrayList<Message>();
		controller = new MessageController(messageService);
	}

	@Test
	public void listShouldCallGetMessages() throws Exception {

		String viewName = controller.list(model);

		assertEquals("messages/messages", viewName);
		verify(messageService, times(1)).getMessages();
		verify(model, times(1)).addAttribute(eq("messages"), anyList());
	}

	@Test
	public void listShouldReturnListOfMessages () throws Exception {
		// given
		initList();

		when(messageService.getMessages()).thenReturn(messages);

		ArgumentCaptor<List<Message>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewName = controller.list(model);

		// then
		assertEquals("messages/messages", viewName);
		verify(messageService, times(1)).getMessages();
		verify(model, times(1)).addAttribute(eq("messages"), argumentCaptor.capture());
		
		List<Message> listInController = argumentCaptor.getValue();
		System.out.println(listInController);
		assertEquals(3, listInController.size());
	}

	private void initList() {
		messages.add(new Message());
		messages.add(new Message());
		messages.add(new Message());
	}
}