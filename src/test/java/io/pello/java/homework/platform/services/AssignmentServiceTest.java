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

import io.pello.java.homework.platform.converters.AssignmentCommandToAssignment;
import io.pello.java.homework.platform.converters.AssignmentToAssignmentCommand;
import io.pello.java.homework.platform.domain.Assignment;
import io.pello.java.homework.platform.repositories.AssignmentRepository;


public class AssignmentServiceTest {

    private AssignmentServiceImpl assignmentService;
    @Autowired
    private AssignmentToAssignmentCommand assignmentToAssignmentCommand;
    @Autowired
    private AssignmentCommandToAssignment assignmentCommandToAssignment;
    
    @Mock
    private AssignmentRepository assignmentRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        assignmentService = new AssignmentServiceImpl(assignmentRepository, assignmentToAssignmentCommand, assignmentCommandToAssignment);
    }

    @Test
    public void getAssignments() throws Exception {
        List<Assignment> assignmentData = new ArrayList<Assignment>();
        assignmentData.add(new Assignment());
        assignmentData.add(new Assignment());
        
        when(assignmentService.getAssignments()).thenReturn(assignmentData);

        List<Assignment> assignments = assignmentService.getAssignments();

        assertEquals(assignments.size(), 2);
        verify(assignmentRepository, times(1)).findAll();
    }

}