package io.pello.java.homework.platform.services;



import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.pello.java.homework.platform.domain.Homework;
import io.pello.java.homework.platform.repositories.HomeworkRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class HomeworkServiceTest {

    HomeworkServiceImpl homeworkService;

    @Mock
    HomeworkRepository homeworkRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        homeworkService = new HomeworkServiceImpl(homeworkRepository);
    }

    @Test
    public void getHomeworks() throws Exception {

        Homework homework = new Homework();
        HashSet receipesData = new HashSet();
        receipesData.add(homework);

        when(homeworkService.getHomeworks()).thenReturn(receipesData);

        Set<Homework> homeworks = homeworkService.getHomeworks();

        assertEquals(homeworks.size(), 1);
        verify(homeworkRepository, times(1)).findAll();
    }

}