package io.pello.java.homework.platform.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTest {

	private Homework homework;

	@Before
	public void setUp() {
		homework = new Homework();
	}

	@Test
	public void getId() throws Exception {
		Long idValue = 4L;

		homework.setId(idValue);

		assertEquals(idValue, homework.getId());
	}

	@Test
	public void getDescription() throws Exception {
	}

	@Test
	public void getRecipes() throws Exception {
	}

}