package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Archer extends GamePiece implements Drawable, Moveable {

	
	public Archer(int location) {
		super('A', "Archer", location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Find current location in game board
		// decide to move left or right to get to player
		// move to next available square in direction of player
		int old = super.getLocation(); //will be set to null if archer moves
		if (super.getLocation() < playerLocation) {
			//move to next available square, or stay if none available
			for(int i = super.getLocation(); i < gameBoard.length; i ++) {
				if(gameBoard[i]==null) {
					super.setLocation(i); //update archer location
					gameBoard[i] = this;
					gameBoard[old] = null;
					break;
				}
			}
		}
		else {
			for(int i = super.getLocation(); i > 0; i --) {
				if(gameBoard[i]==null) {
					super.setLocation(i);
					gameBoard[i] = this;
					gameBoard[old] = null;
					break;
				}
			}
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// if no pieces between player and archer, player loses a heart
		//check right
		for(int i = super.getLocation(); i < gameBoard.length; i ++) {
			if(i == playerLocation) {
				return(InteractionResult.HIT);
			}
			else if(gameBoard[i]!=null) {
				break;
			}
		}
		//check left
		//
		for(int i = super.getLocation(); i > 0; i --) {
			if(i == playerLocation) {
				return(InteractionResult.HIT);
			}
			else if(gameBoard[i]!=null) {
				break;
			}
		}
		return(InteractionResult.NONE);
	}
	
}
