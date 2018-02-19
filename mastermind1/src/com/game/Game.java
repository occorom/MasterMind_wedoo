package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
	/* Number of right Pawns. */
	private int nbRightPawns;
	/* Number of right colors. */
	private int nbRightColor;
	/* Number of rounds. */
	private int round;
	/* true when the game if ended. */
	private boolean partyEnded = false;
	/* Array to keep track of already entered strings. */
	private String[] history;


	/* User input */
	private UserInput userInput;
	/* Computer input */
	private ComputerInput computerInput;

	/* Buffer reader. */
    private BufferedReader br;


	/**
	 * Default constructor.
	 * @param pComputer input the input of the computer.
	 **/
	public Game(ComputerInput pComputerInput) {
		this.round = 1;
		this.computerInput = pComputerInput;
		userInput = new UserInput();
		this.history = new String[10];
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * starts the game.
	 * @throws IOException when a reading error occurs.
	 */
	public void start() throws IOException {
		String startingPhrase = "Ordinateur > J’ai choisit ma combinaison, à vous de deviner ! "
				+ "Les couleurs possibles sont R J B O V et N. Tapez (RJBO) pour tenter les couleurs R"
				+ "J,B et O dans l’ordre.\n";
		System.out.printf(startingPhrase);
		while (!partyEnded) {
			if (round < 10) {
				playRound();
			} else {
				System.out.println("Vous avez atteint dix tours sans gagner :-(");
				partyEnded = true;
				return;
			}
		}
		if (partyEnded) {
			displayCurrentState(history);
			System.out.println("Bravo ! Vous avez devinez en " + (round-1) + "tours");
		}
	}

	/**
	 * plays a round and dispays the output to user.
	 * @throws IOException when a reading error occurs.
	 */
	private void playRound() throws IOException {
		if (round != 1) {
			// only display output after first round.
			displayCurrentState(history);
		}
		System.out.printf("$>");
		// ask for user input
		String input = String.valueOf(userInput.getNewInput(br));
		// initialize all
		List<String> foundColors = new ArrayList<String>();
		int index = 0;
		nbRightColor = 0;
		nbRightPawns = 0;
		for (char c : input.toCharArray()) {
			if (computerInput.getComputerString().contains(String.valueOf(c))) {
				if (!foundColors.contains(String.valueOf(c))) {
					foundColors.add(String.valueOf(c));
					// only add color if not already found
					nbRightColor++;
				}
				char[] cptChar = computerInput.getInput();
				if (cptChar[index] == c) {
					nbRightPawns++;
				}
			}
			index++;
		}
		// keep history of all previous entries and results.
		history[round - 1] = "| " + input + " | " + nbRightPawns + " | " + nbRightColor + " | " + round +"/10 |";
		// if right paws equals 4, it means we have all right colors at the correct index => game won
		if (nbRightPawns == 4) {
			partyEnded = true;
		}
		round++;
	}

	/**
	 * displays current game state.
	 * @param newInput all strings to display.
	 */
	private void displayCurrentState(final String[] newInput) {
		System.out.println("|---------------------|");
		for (String entry : newInput) {
			if (entry != null) {
				System.out.println(entry);
			}
		}
	}

	public ComputerInput getComputerInput() {
		return computerInput;
	}
}
