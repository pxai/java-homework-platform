package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.domain.Homework;
import io.pello.java.homework.platform.domain.Message;
import io.pello.java.homework.platform.services.HomeworkService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

public class HomeworkControllerTest {

    @Mock
    HomeworkService homeworkService;

    @Mock
    Model model;

    HomeworkController controller;
    
    List<Homework> homeworks;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        homeworks = new ArrayList<Homework>();
        
        controller = new HomeworkController(homeworkService);
    }
    
    @Test
    public void shouldReturnIndex() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/homeworks"))
                .andExpect(status().isOk())
                .andExpect(view().name("homeworks/homeworks"));
    }

    @Test
    public void listShouldCallGetHomework() throws Exception {

        String viewName = controller.list(model);

        assertEquals("homeworks/homeworks", viewName);
        verify(homeworkService, times(1)).getHomeworks();
        verify(model, times(1)).addAttribute(eq("homeworks"), anyList());
    }

    
	@Test
	public void listShouldReturnListOfHomework () throws Exception {
		// given
		initList();

		when(homeworkService.getHomeworks()).thenReturn(homeworks);

		ArgumentCaptor<List<Message>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewName = controller.list(model);

		// then
		List<Message> listInController = argumentCaptor.getValue();
		System.out.println(listInController);
		assertEquals(3, listInController.size());
	}

	private void initList() {
		homeworks.add(new Homework());
		homeworks.add(new Homework());
		homeworks.add(new Homework());
	}
}