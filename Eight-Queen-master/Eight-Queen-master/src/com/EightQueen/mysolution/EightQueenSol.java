package com.EightQueen.mysolution;

/**
 * @author nilay
 * 
 *         Class EightQueenSol outputs only one outcome of the Eight Queens
 *         Problem. The approach used is known as Backtracking. The eight queens
 *         puzzle is the problem of placing eight chess queens on an 8×8
 *         chessboard so that no two queens threaten each other; thus, a
 *         solution requires that no two queens share the same row, column, or
 *         diagonal.
 *
 */
public class EightQueenSol {

	/**
	 * Prints the board on the console.
	 * 
	 * @param chessBoard it takes the final state of the chess board as a 2D array.
	 */
	public static void display(int[][] chessBoard) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				if (chessBoard[i][j] == 1) {
					System.out.print("Q\t");
				} else {
					System.out.print("__\t");
				}
			System.out.println("\n");
		}
	}

	/**
	 * Check the positions which satisfies the constraints or performs backtracking.
	 * 
	 * @param chessBoard takes current state of the board
	 * @param col        current column
	 * @return a boolean value to verify if it has a solution or not.
	 */
	public static boolean chessBoarder(int[][] chessBoard, int col) {

		if (col >= 8) { // Base case i.e, if all the columns are covered satisfying the constraints
			return true;
		}

		for (int k = 0; k < 8; k++) {
			if (isQueenSafe(chessBoard, k, col)) { // Calling the helper method to check if the position satisfies the
													// constraints
				chessBoard[k][col] = 1; // If the current position is safe then placing 1 on the position
				if (chessBoarder(chessBoard, col + 1)) { // Recursive call to check the next column
					return true;
				}
				chessBoard[k][col] = 0; // If the above call fails then Backtrack.
			}
		}
		return false;
	}

	/**
	 * A Utility method which checks the constraints in the left(rows), upper-left
	 * (diagonal) and bottom-left (diagonal) positions
	 * 
	 * @param chessBoard takes the current state of the board
	 * @param row        takes current row
	 * @param col        takes the current column
	 * @return boolean value if the position is safe or not.
	 */
	public static boolean isQueenSafe(int[][] chessBoard, int row, int col) {
		int i, j;
		for (i = 0; i < col; i++) {
			if (chessBoard[row][i] == 1) // Checks if there is already a position covered in the same row.
				return false;
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) // Checks if there is already a position covered in the upper-left diagonal.
				return false;
		}
		for (i = row, j = col; j >= 0 && i < 8; i++, j--) {
			if (chessBoard[i][j] == 1) // Checks if there is already a position covered in the bottom-left diagonal.
				return false;
		}
		return true;

	}

}
