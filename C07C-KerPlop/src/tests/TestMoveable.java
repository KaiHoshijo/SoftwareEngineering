package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.*;

public class TestMoveable {

	@Test
	public void testArcher() {
		// setting up the game board and archer for initial test
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// creating archer for this test
		Archer archer = new Archer(3);
		gameBoard[3] = archer;
		// Tests where the archer will jump onto the player if there is any number
		// of objects in the way
		// first test: One object
		gameBoard[2] = new Bush();
		archer.move(gameBoard,0);
		assertEquals(archer.getLocation(), 1);
		// second test: five objects
		gameBoard[1] = null;
		for (int i = 3; i <= 6; i++) {
			gameBoard[i] = new Bush();
		}
		archer.setLocation(7);
		gameBoard[7] = archer;
		archer.move(gameBoard, 1);
		assertEquals(archer.getLocation(), 1);
		// third test: five objects in the other way
		archer.move(gameBoard, 8);
		assertEquals(archer.getLocation(), 7);
		// final test: archer moves one position closer to player
		archer.move(gameBoard, 9);
		assertEquals(archer.getLocation(), 8);
	}
		
}
