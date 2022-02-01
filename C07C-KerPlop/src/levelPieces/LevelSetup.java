package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {

	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private int startPlayer;
	private ArrayList<GamePiece> interactingPieces;
	
	public void createLevel(int levelNum) {
		// Create level for level 1
		board = new Drawable[10];
		board[2] = new Bush();
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		startPlayer = 0;
		//Create level for level 2
		
	}

	public Drawable[] getBoard() {
		//return all of the pieces on the board
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		//Return all of the moveable pieces
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		//Return all of the pieces with interactions
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		//Return where the player starts in a level
		return startPlayer;
	}

}
