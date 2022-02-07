package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

public class Lich extends GamePiece implements Moveable {
	private Random randomLocation = new Random();
	
	public Lich(int location, Drawable[] gameBoard) {
		super('L', "Lich", location);		
	}
	
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		// getting the old location of the lich in order to not land there again
		int old = super.getLocation();
		
		// Get a new location for the lich
		int newLocation = getRandomLocation(gameBoard, old);
		
		// Once the new location is found, the lich will "teleport" there and the old location is eliminated
		super.setLocation(newLocation);
		gameBoard[old] = null;
		gameBoard[newLocation] = this;
		
	}
	
	public int getRandomLocation(Drawable[] gameBoard, int currentLocation) {
		// The lich moves by teleporting to a random square throughout the board
		// Therefore, the new board position will be generated until a null position is found
		// Generate initial new location
		int newLocation = 0;
		do {
			newLocation = randomLocation.nextInt(0, GameEngine.BOARD_SIZE);
		}
		while (gameBoard[newLocation] != null && newLocation != currentLocation);
		
		return newLocation;
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// Finding the player's position relative to the lich
		int difference = Math.abs(playerLocation - super.getLocation());
		
		// The lich will fire a "fireball" up to a random number of locations from 1 to 5 that can go through any thing
		// The fireball can only hurt the player
		int fireballSpace = randomLocation.nextInt(1, 6);
		// If the difference between the player and lich is less than the fireball then the player shall be
		// consumed by the hellfire that is summoned by cursed lich!
		return difference - fireballSpace <= 0 ? InteractionResult.KILL : InteractionResult.NONE;
	}
	
}
 