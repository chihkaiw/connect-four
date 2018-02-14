package connect.utils;

import connect.model.Board;
import connect.model.Disc;

public class Judge {

  /**
   * Check the game board with given disc type.
   *
   * @param gameBoard
   * @param player
   * @return Result of checking game board.
   */
  public boolean checkWin(Board gameBoard, Disc target) {

    // Horizontal Check
    for (int i = 1; i <= gameBoard.getRowSize(); i++) {
      for (int j = 1; j <= gameBoard.getColSize() - 3; j++) {
        if (gameBoard.getDisc(i, j) == target && gameBoard.getDisc(i, j + 1) == target
            && gameBoard.getDisc(i, j + 2) == target && gameBoard.getDisc(i, j + 3) == target) {
          return true;
        }
      }
    }

    // Vertical Check
    for (int j = 1; j <= gameBoard.getColSize(); j++) {
      for (int i = 1; i <= gameBoard.getRowSize() - 3; i++) {
        if (gameBoard.getDisc(i, j) == target && gameBoard.getDisc(i + 1, j) == target
            && gameBoard.getDisc(i + 2, j) == target && gameBoard.getDisc(i + 3, j) == target) {
          return true;
        }
      }
    }

    // Ascending Diagonal Check
    for (int i = 4; i <= gameBoard.getRowSize(); i++) {
      for (int j = 1; j <= gameBoard.getColSize() - 3; j++) {
        if (gameBoard.getDisc(i, j) == target && gameBoard.getDisc(i - 1, j + 1) == target
            && gameBoard.getDisc(i - 2, j + 2) == target
            && gameBoard.getDisc(i - 3, j + 3) == target)
          return true;
      }
    }

    // Descending Diagonal Check
    for (int i = 4; i <= gameBoard.getRowSize(); i++) {
      for (int j = 4; j <= gameBoard.getColSize(); j++) {
        if (gameBoard.getDisc(i, j) == target && gameBoard.getDisc(i - 1, j - 1) == target
            && gameBoard.getDisc(i - 2, j - 2) == target
            && gameBoard.getDisc(i - 3, j - 3) == target)
          return true;
      }
    }
    return false;
  }
}
