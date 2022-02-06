package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class HomicidalPlant extends GamePiece {

	public HomicidalPlant(int location) {
		super('H', "Homicidal Plant", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == super.getLocation()) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
