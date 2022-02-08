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
		// Tests where the archer will jump near the player if there is any number
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
	
	//We got this test from the description of the assingment
	/*
	 * Tests random motion, used by both the Sniper and Unicorn.
	 * Strategy: 
	 * - Place pieces in all spaces EXCEPT 0, 6, 12, 13, 20.
	 * - Ensures both end spots (0 and 20) are open.
	 * - Same piece is used in all spaces, as piece identity doesn't matter.
	 * - Set player location to space 13.
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */
	@Test
	public void testRandomMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Bush();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Bush();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Bush();
		// Place Lich in an open space - 6
		// Note that Lich location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Lich lich = new Lich(6, gameBoard);
		gameBoard[6] = lich;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			lich.move(gameBoard, 13);
			int loc = lich.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20 && loc != 13) {
				fail("Invalid square selected");
			}
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 10);
		assert(count6 > 10);
		assert(count12 > 10);
		assert(count20 > 10);		
	}
		
}
