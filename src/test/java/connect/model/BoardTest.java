package connect.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

  private static final int NUMBER_OF_ROWS = 6;
  private static final int NUMBER_OF_COLUMNS = 7;

  private Board board;


  @Before
  public void setup() {
    board = new Board(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
  }

  @Test
  public void isBoardFull_NotFull_ReturnFalse() {
    Assert.assertFalse(board.isBoardFull());
  }

  @Test
  public void isBoardFull_Full_ReturnTrue() {
    board = getFullBoard();
    Assert.assertTrue(board.isBoardFull());
  }

  @Test
  public void isColumnsFull_NotFull_ReturnFalse() {
    Assert.assertFalse(board.isColumnsFull(1));
  }

  @Test
  public void isColumnsFull_Full_ReturnTrue() {
    board = getFullBoard();
    Assert.assertTrue(board.isColumnsFull(1));
  }

  @Test
  public void getRowSize_ReturnRowSize() {
    Assert.assertEquals(NUMBER_OF_ROWS, board.getRowSize());
  }

  @Test
  public void getColSize_ReturnColSize() {
    Assert.assertEquals(NUMBER_OF_COLUMNS, board.getColSize());
  }

  @Test
  public void getDisc_EmptyBoard_ReturnEmptyDisc() {
    Assert.assertEquals(Disc.NONE, board.getDisc(1, 1));
  }

  @Test
  public void getDisc_HasRedDisc_ReturnRedDisc() {
    board.dropDisc(1, Disc.RED);
    Assert.assertEquals(Disc.RED, board.getDisc(1, 1));
  }

  @Test
  public void getDisc_HasGreenDisc_ReturnGreenDisc() {
    board.dropDisc(1, Disc.GREEN);
    Assert.assertEquals(Disc.GREEN, board.getDisc(1, 1));
  }

  @Test
  public void dropDisc_DropRedDisc_CanFindRedDisc() {
    board.dropDisc(1, Disc.RED);
    Assert.assertEquals(Disc.RED, board.getDisc(1, 1));
  }

  @Test
  public void undoPreviousMove_UndoSingleDisc_ShouldUndo() {
      board.dropDisc(1, Disc.RED);
      board.undoPreviousMove();
      Assert.assertEquals(Disc.NONE, board.getDisc(1, 1));
  }
 
  @Test
  public void undoPreviousMove_UndoMultipleDisc_ShouldUndo() {
      board.dropDisc(1, Disc.RED);
      board.dropDisc(1, Disc.RED);
      board.dropDisc(1, Disc.RED);

      board.undoPreviousMove();
      board.undoPreviousMove();

      Assert.assertEquals(Disc.RED, board.getDisc(1, 1));
      Assert.assertEquals(Disc.NONE, board.getDisc(2, 1));
      Assert.assertEquals(Disc.NONE, board.getDisc(3, 1));
  }

  @Test
  public void undoPreviousMove_BoardIsEmpty_ShouldNotUndo() {
      board.undoPreviousMove();
      Assert.assertEquals(Disc.NONE, board.getDisc(1, 1));
  }


  private Board getFullBoard() {
    Board fullBoard = new Board(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    for (int i = 0; i < NUMBER_OF_ROWS; i++) {
      for (int j = 1; j <= NUMBER_OF_COLUMNS; j++) {
        fullBoard.dropDisc(j, Disc.RED);
      }
    }
    return fullBoard;
  }
}
