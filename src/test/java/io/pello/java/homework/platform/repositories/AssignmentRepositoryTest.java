package io.pello.java.homework.platform.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.pello.java.homework.platform.domain.Assignment;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AssignmentRepositoryTest {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldFindById() throws Exception {
        Optional<Assignment> assignment = assignmentRepository.findById(1L);
        assertEquals(1, assignment.get().getId().intValue());
    }

    @Test
    public void shoudlFindByName() throws Exception {
        List<Assignment> assignmentList = assignmentRepository.findByName("test");
        assertEquals(1, assignmentList.size());
    }

}