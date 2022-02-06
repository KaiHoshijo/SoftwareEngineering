package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class HealthPotion extends GamePiece {

	public HealthPotion(int location) {
		super('D', "Health Potion", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == super.getLocation()) {
			return InteractionResult.HEAL;
		}
		return InteractionResult.NONE;
	}

	
}
