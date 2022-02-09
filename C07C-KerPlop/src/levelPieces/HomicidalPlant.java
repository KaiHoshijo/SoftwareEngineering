package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class HomicidalPlant extends GamePiece {

	public HomicidalPlant(int location) {
		super('H', "Homicidal Plant", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//It's a plant, so as much as it would like to, it can't hurt the player
		return InteractionResult.NONE;
	}

}
