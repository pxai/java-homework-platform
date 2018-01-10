package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.services.HomeworkService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HomeworkControllerTest {

    @Mock
    HomeworkService homeworkService;

    @Mock
    Model model;

    HomeworkController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new HomeworkController(homeworkService);
    }

    @Test
    public void getIndexPage() throws Exception {

        String viewName = controller.list(model);

        assertEquals("homeworks/homeworks", viewName);
        verify(homeworkService, times(1)).getHomeworks();
        verify(model, times(1)).addAttribute(eq("homeworks"), anyList());
    }

}