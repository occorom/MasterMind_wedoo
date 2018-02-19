package com.game;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.game.UserInput;

public class UserInputTest {

	UserInput sut;

	@Before
	public void setUp() {
		sut = new UserInput();
	}

	@Test
	public void test() {
		assertFalse(sut.isInputMatching(""));
		assertFalse(sut.isInputMatching("ABCD"));
		assertTrue(sut.isInputMatching("ROOJ"));
		assertTrue(sut.isInputMatching("RBVJ"));
		assertTrue(sut.isInputMatching("RBNJ"));
		assertTrue(sut.isInputMatching("RJON"));
		assertTrue(sut.isInputMatching("RVON"));
	}

}
