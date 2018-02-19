package com.game;

import java.util.Random;

public class ComputerInput extends AbstractInput {
	private final static String ALLOWED_CHARS = "RJBOVN";
	private static String computerString;
	
	public ComputerInput() {
		this.fInput = new char[4];
        Random rnd = new Random();
        int i = 0;
        while (i < 4) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ALLOWED_CHARS.length());
            fInput[i] = ALLOWED_CHARS.charAt(index);
            i++;
        }
        computerString = String.valueOf(fInput);
	}

	public char[] getInput() {
		return fInput;
	}
	
	public String getComputerString() {
		return computerString;
	}

}
