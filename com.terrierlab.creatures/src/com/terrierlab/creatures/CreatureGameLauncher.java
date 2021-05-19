package com.terrierlab.creatures;

import com.terrierlab.creatures.model.Board;

public class CreatureGameLauncher {

	public static void main(String[] args) {
		Board board = new Board(10, 10, 2);
		board.play();

	}

}
