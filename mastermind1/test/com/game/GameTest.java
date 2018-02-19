package com.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.game.ComputerInput;
import com.game.Game;

public class GameTest {

	Game sut;

	@Before
	public void setUp() {
		ComputerInput cp = new ComputerInput();
		sut = new Game(cp);
	}
	
	@Test
	public void test() throws IOException {
		assertNotNull(sut.getComputerInput());
		String s = sut.getComputerInput().getComputerString();
		assertEquals(4, s.length());
	}

}
