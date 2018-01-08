package io.pello.java.homework.platform.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssignmentTest {

	private Assignment assignment;

	@Before
	public void setUp() {
		assignment = new Assignment();
	}

	@Test
	public void getId() throws Exception {
		Long idValue = 4L;

		assignment.setId(idValue);

		assertEquals(idValue, assignment.getId());
	}

	@Test
	public void getDescription() throws Exception {
	}

	@Test
	public void getRecipes() throws Exception {
	}

}