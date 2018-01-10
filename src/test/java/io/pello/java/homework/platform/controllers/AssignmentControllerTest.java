package io.pello.java.homework.platform.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import io.pello.java.homework.platform.domain.Assignment;
import io.pello.java.homework.platform.domain.Message;
import io.pello.java.homework.platform.services.AssignmentService;
import io.pello.java.homework.platform.services.HomeworkService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class AssignmentControllerTest {

    @Mock
    private AssignmentService assignmentService;

    @Mock
    private Model model;

    private AssignmentController controller;

    
    List<Assignment> assignments;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        assignments = new ArrayList<Assignment>();
        
        controller = new AssignmentController(assignmentService);
    }

    @Test
    public void listShouldCallGetAssignments() throws Exception {

        String viewName = controller.list(model);

        assertEquals("assignments/assignments", viewName);
        verify(assignmentService, times(1)).getAssignments();
        verify(model, times(1)).addAttribute(eq("assignments"), anyList());
    }
    
	@Test
	public void listShouldReturnListOfAssignment() throws Exception {
		// given
		initList();

		when(assignmentService.getAssignments()).thenReturn(assignments);

		ArgumentCaptor<List<Message>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewName = controller.list(model);

		// then
		List<Message> listInController = argumentCaptor.getValue();
		System.out.println(listInController);
		assertEquals(3, listInController.size());
	}

	private void initList() {
		assignments.add(new Assignment());
		assignments.add(new Assignment());
		assignments.add(new Assignment());
	}

}