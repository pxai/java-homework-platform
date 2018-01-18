package io.pello.java.homework.platform.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.pello.java.homework.platform.domain.Message;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageRepositoryTest {

    @Autowired
    MessageRepository messageRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldFindByTitle() throws Exception {
        List<Message> messageList = messageRepository.findByTitle("Teaspoon");
        assertEquals(1, messageList.size());
    }

    @Test
    public void shoudlFindByContent() throws Exception {
        List<Message> messageList = messageRepository.findByContent("Cup");
        assertEquals(1, messageList.size());
    }

}