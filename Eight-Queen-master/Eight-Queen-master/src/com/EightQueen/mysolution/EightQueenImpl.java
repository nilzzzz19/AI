package com.EightQueen.mysolution;

/**
 * 
 * @author nilay
 * 
 *         This is just an Implementation class for EightQueenSol class
 *
 */
public class EightQueenImpl {

	public static void main(String[] args) {
		int[][] chessBoard = new int[8][8];
		if (!EightQueenSol.chessBoarder(chessBoard, 0)) {
			System.out.println("There's no solution");
		}
		EightQueenSol.display(chessBoard);

	}

}
