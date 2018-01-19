package io.pello.java.homework.platform.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.pello.java.homework.platform.domain.Assignment;
import io.pello.java.homework.platform.domain.Homework;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HomeworkRepositoryTest {

    @Autowired
    HomeworkRepository homeworkRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldFindById() throws Exception {
        Optional<Homework> homework = homeworkRepository.findById(1L);
        assertEquals(1, homework.get().getId().intValue());
    }

    @Test
    public void shoudlFindByTitle() throws Exception {
        List<Homework> homeworkList = homeworkRepository.findByTitle("Test");
        assertEquals(1, homeworkList.size());
    }

}