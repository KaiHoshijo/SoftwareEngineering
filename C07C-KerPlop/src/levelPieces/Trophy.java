package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Trophy extends GamePiece {

	public Trophy(int location) {
		super('T', "Trophy", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// If playerLocation = location for this piece, add point
		if (super.getLocation() == playerLocation) {
			return(InteractionResult.GET_POINT);
		}
		else {
			return(InteractionResult.NONE);
		}
	}

}
