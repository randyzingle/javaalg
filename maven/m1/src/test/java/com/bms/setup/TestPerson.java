package com.bms.setup;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerson {
	
	private Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person();
		person.firstName = "Baldur";
		person.lastName = "Zingle";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(person.firstName, "Baldur");
	}

}
