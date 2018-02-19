package com.game;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInput extends AbstractInput {

	/** the pattern to match. */
	private static final String PATTERN = "^[ROBJVN]+$";

	public UserInput() {
	}
	
	public void setInput(final char[] pInput) {
		this.fInput = pInput;
	}

	/**
	 * gets a new input from the user.
	 * @param br the buffer reader.
	 * @return the user input.
	 * @throws IOException when an error occurs.
	 */
	public char[] getNewInput(BufferedReader br) throws IOException {
		String input = br.readLine();
		while (!isInputMatching(input)) {
			System.out.printf("Réessayez !!: $>");
			System.out.printf("");
			input = br.readLine();
		}
		fInput = input.toCharArray();
		return fInput;
	}

	/**
	 * checks that user's input meets the required entry conditions.
	 * @param pInput the input.
	 * @return true if the entry is correct.
	 */
	protected boolean isInputMatching(final String pInput) {
		return pInput.length() == 4 && pInput.matches(PATTERN);
	}
	
}
