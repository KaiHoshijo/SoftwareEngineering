package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Archer extends GamePiece implements Drawable, Moveable {

	private int range;
	
	public Archer(int location, int size) {
		super('A', "Archer", location);
		range = size;
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Find current location in game board
		// decide to move left or right to get to player
		// move to next available square in direction of player
		

	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// if no pieces between player and archer, player loses a heart
		return null;
	}
	
}
