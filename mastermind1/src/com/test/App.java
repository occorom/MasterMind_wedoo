package com.test;

import java.io.IOException;

import com.game.ComputerInput;
import com.game.Game;

public class App {
	public static void main(String[] args) throws IOException { 
        ComputerInput cmpInput = new ComputerInput();
        
        Game game = new Game(cmpInput);
        game.start();

    }
}
