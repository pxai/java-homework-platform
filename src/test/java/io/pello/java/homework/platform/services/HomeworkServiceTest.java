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

import io.pello.java.homework.platform.converters.HomeworkCommandToHomework;
import io.pello.java.homework.platform.converters.HomeworkToHomeworkCommand;
import io.pello.java.homework.platform.domain.Homework;
import io.pello.java.homework.platform.repositories.HomeworkRepository;


public class HomeworkServiceTest {

    private HomeworkServiceImpl homeworkService;
    @Autowired
    private HomeworkToHomeworkCommand homeworkToHomeworkCommand;
    @Autowired
    private HomeworkCommandToHomework homeworkCommandToHomework;
    
    @Mock
    private HomeworkRepository homeworkRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        homeworkService = new HomeworkServiceImpl(homeworkRepository, homeworkToHomeworkCommand, homeworkCommandToHomework);
    }

    @Test
    public void getHomeworks() throws Exception {
        List<Homework> homeworkData = new ArrayList<Homework>();
        homeworkData.add(new Homework());
        homeworkData.add(new Homework());
        
        when(homeworkService.getHomeworks()).thenReturn(homeworkData);

        List<Homework> homeworks = homeworkService.getHomeworks();

        assertEquals(homeworks.size(), 2);
        verify(homeworkRepository, times(1)).findAll();
    }

}