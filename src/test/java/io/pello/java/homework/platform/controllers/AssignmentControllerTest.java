package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.services.AssignmentService;
import io.pello.java.homework.platform.services.HomeworkService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AssignmentControllerTest {

    @Mock
    private AssignmentService assignmentService;

    @Mock
    private Model model;

    private AssignmentController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new AssignmentController(assignmentService);
    }

    @Test
    public void getIndexPage() throws Exception {

        String viewName = controller.list(model);

        assertEquals("index", viewName);
        verify(assignmentService, times(1)).getAssignments();
        verify(model, times(1)).addAttribute(eq("assignments"), anySet());
    }

}