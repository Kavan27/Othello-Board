// TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * This Class runs a Human vs Human Othello Game
 * 
 * It consists of a game board, and keeping track of which player's
 * turn it currently is along with asking for the input and it also keeps track of the number of 
 * tokens of each player on the board. It knows when to end the game and also show who wins the game
 */
public class OthelloControllerHumanVSHuman {

	protected Othello othello;
	PlayerHuman player1, player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with two users at the console.
	 */
	public OthelloControllerHumanVSHuman() {
		
		this.othello = new Othello();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(this.othello, OthelloBoard.P2);
	}
	/**
	 * Runs until game is over. Gets whose turn it is and lets the player
	 * make their move, and calls reportMove and makes the move and finally at
	 * the end calls reportFinal
	 */
	public void play() {
		
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhoseTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}
	/**
	 * Prints the token of who's turn it is and what move in (row, col) they make.
	 * 
	 * @param whosTurn  The player token of whose turn it is
	 * @param move  The move that that player makes in a (row, col) format
	 */
	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}
	/**
	 * Prints the updated board after the player makes a move, prints
	 * the count of tokens for each player and prints which player has 
	 * the next move.
	 */
	private void report() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  " 
				+ othello.getWhoseTurn() + " moves next";
		System.out.println(s);
	}
	/**
	 * Prints the final board with both player counts and checks and prints
	 * the player that has the highest count after no more moves are possible
	 */
	private void reportFinal() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) 
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
	
	/**
	 * Run main to play two Humans against each other at the console.
	 * @param args
	 */
	public static void main(String[] args) {
		
		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
		oc.play();
	}

}
