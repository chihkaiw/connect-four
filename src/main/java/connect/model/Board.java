package connect.model;

import connect.constant.Const;

public class Board {

  private Disc[][] gameBoard;
  private int counter = 0;
  private int rowSize;
  private int colSize;

  public Board(int rowSize, int colSize) {
    this.rowSize = rowSize;
    this.colSize = colSize;
    this.gameBoard = initBoard(rowSize, colSize);
    this.counter = rowSize * colSize;
  }

  /**
   * Initialize the game board.
   *
   * @param row
   * @param col
   * @return board
   */
  private Disc[][] initBoard(int row, int col) {
    Disc[][] result = new Disc[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        result[i][j] = Disc.NONE;
      }
    }
    return result;
  }

  /**
   * Check the board if it has more free space or not.
   *
   * @return true if the board has no more free space, otherwise false.
   */
  public boolean isBoardFull() {
    return counter == 0;
  }

  /**
   * Check the selected column if it has more free space or not.
   *
   * @param column
   * @return true if the select column have no more free space, otherwise false.
   */
  public boolean isColumnsFull(int col) {
    return !gameBoard[rowSize - 1][col - 1].equals(Disc.NONE);
  }

  /**
   * Get row size.
   *
   * @return Row Size
   */
  public int getRowSize() {
    return rowSize;
  }

  /**
   * Get column size.
   *
   * @return Column Size
   */
  public int getColSize() {
    return colSize;
  }

  /**
   * Get the disc value at the specified row and column.
   *
   * @param row
   * @param column
   * @return Disc
   */
  public Disc getDisc(int row, int col) {
    return gameBoard[row - 1][col - 1];
  }

  /**
   * Drop current player's Disc to the board with given column.
   *
   * @param col
   * @param Disc
   */
  public void dropDisc(int col, Disc disc) {
    for (int i = 0; i < gameBoard.length; i++) {
      if (gameBoard[i][col - 1].equals(Disc.NONE)) {
        gameBoard[i][col - 1] = disc;
        counter--;
        break;
      }
    }
  }

  /**
   * Show the current board on the STDOUT.
   */
  public void showBoard() {
    int row = gameBoard.length;
    int col = gameBoard[0].length;
    int boardSize = col * 2 + 1;

    for (int i = row - 1; i >= 0; i--) {
      for (int j = 0; j < boardSize; j++) {
        if (j % 2 != 0) {
          System.out.print(gameBoard[i][j / 2].getImage());
        } else {
          this.printWall(j, boardSize);
        }
      }
    }
    System.out.println();
  }

  private void printWall(int index, int boardSize) {
    if (index == boardSize - 1) {
      System.out.println(Const.GUI_WALL);
    } else {
      System.out.print(Const.GUI_WALL);
    }
  }
}
