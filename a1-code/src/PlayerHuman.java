import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * This class keeps track of the player and its inputs
 * 
 * It takes the input of row and col in a format (row, col) and it makes sure
 * that the input is valid
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;

	/**
	 * Constructs a Othello class which consists of game board and keeps track of some
	 * statistics. Also constructs 2 player inputs. 
	 * @param othello  creates a Othello class
	 * @param player  creates player inputs
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}
	
	/**
	 * Takes an input for the row and col from the user and returns a Move object
	 * @return  the row and col inputed by the user and returns it as a move object
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}
	
	/**
	 * Makes a loop that asks the user the row and col until a valid move has been chosen
	 * @param message  gets a string that prints at the start before user input is read
	 * @return return the int move if input is valid or returns -1 if the input is invalid
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
