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
}
