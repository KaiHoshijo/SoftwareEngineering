package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.*;
import levelPieces.*;

public class TestInteractions {

	
	@Test
	public void testArcher() {
	//If no pieces between player and archer, player loses a heart. Otherwise, nothing 
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Archer archer = new Archer(5);
		gameBoard[5] = archer;
		gameBoard[3] = new Bush();
		gameBoard[8] = new Bush();
		//check for no interaction if on same square as archer
		assertEquals(InteractionResult.NONE, archer.interact(gameBoard, 5));
		// hit points if player is not shielded
		for (int i=3; i<5; i++) {
			assertEquals(InteractionResult.HIT, archer.interact(gameBoard, i));}
		// hit points if player is not shielded
		for (int i=6; i<9; i++) {
			assertEquals(InteractionResult.HIT, archer.interact(gameBoard, i));}
		// These loops ensure no interaction if player shielded by bush(not including square bush is on)
		for (int i=0; i<3; i++) {
			assertEquals(InteractionResult.NONE, archer.interact(gameBoard, i));}
		for (int i=9; i<GameEngine.BOARD_SIZE; i++)	{
			assertEquals(InteractionResult.NONE, archer.interact(gameBoard, i));}
	}	
	
	@Test
	public void testHomicidalPlant() { //should never do anything
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		HomicidalPlant plant = new HomicidalPlant(10);
		gameBoard[10] = plant;
		//make sure nothing happens
		for (int i=0; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, plant.interact(gameBoard, i));
	}
	@Test
	//code taken from assignment description
	public void testTrophy() { //Should give win point if on same square
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Trophy trophy = new Trophy(10);
		gameBoard[10] = trophy;
		// Win points if player on same space
		assertEquals(InteractionResult.GET_POINT, trophy.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, trophy.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, trophy.interact(gameBoard, i));
	}
	@Test
	// The lich should kill the player if within a correct distance
	public void testLich() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Lich lich = new Lich(5, gameBoard);
		gameBoard[5] = lich;
		// Player should be kill if it is close enough to the lich
		assertEquals(InteractionResult.KILL, lich.interact(gameBoard, 4));
		// This should work on either sides of the lich
		assertEquals(InteractionResult.KILL, lich.interact(gameBoard, 6));
		
		// Should be able to work up to five spaces away
		int fiveSpace = 0;
		for (int i = 0; i < 50; i++) {
			if (InteractionResult.KILL.equals(lich.interact(gameBoard, 0))) {
				fiveSpace++;
				break;
			}
		}
		
		assert(fiveSpace == 1);
		
		// Should be no issues if the lich is far enough
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, lich.interact(gameBoard, i));
		}
		
	}
	
	@Test
	// The player should be healed when it's on the health potion
	public void testHealthPotion() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		HealthPotion potion = new HealthPotion(3);
		gameBoard[3] = potion;
		
		// Player should be healed when on the same space
		assertEquals(InteractionResult.HEAL, potion.interact(gameBoard, 3));
		
		// Player should have no interaction if no where else
		for (int i = 0; i < 3; i++) {
			assertEquals(InteractionResult.NONE, potion.interact(gameBoard, i));
		}
		for (int i = 4; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, potion.interact(gameBoard, i));
		}
	}
}
