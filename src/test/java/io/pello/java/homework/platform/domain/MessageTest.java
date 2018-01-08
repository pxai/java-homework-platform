package io.pello.java.homework.platform.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

	private Message message;

	@Before
	public void setUp() {
		message = new Message();
	}

	@Test
	public void getId() throws Exception {
		Long idValue = 4L;

		message.setId(idValue);

		assertEquals(idValue, message.getId());
	}

	@Test
	public void getDescription() throws Exception {
	}

	@Test
	public void getRecipes() throws Exception {
	}

}