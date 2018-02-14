package connect.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import connect.model.Board;
import connect.model.Disc;

public class JudgeTest {
  private static final int NUMBER_OF_ROWS = 6;
  private static final int NUMBER_OF_COLUMNS = 7;
  private Board testGameBoard;
  private Judge testJudge;

  @Before
  public void setup() {
    testGameBoard = new Board(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    testJudge = new Judge();
  }

  @Test
  public void checkWin_NoConnect_Nowin() {
    Assert.assertFalse(testJudge.checkWin(testGameBoard, Disc.RED));
  }

  @Test
  public void checkWin_HorizontalConnect_win() {
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(2, Disc.RED);
    testGameBoard.dropDisc(3, Disc.RED);
    testGameBoard.dropDisc(4, Disc.RED);

    Assert.assertTrue(testJudge.checkWin(testGameBoard, Disc.RED));
  }

  @Test
  public void checkWin_VerticalConnect_win() {
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(1, Disc.RED);

    Assert.assertTrue(testJudge.checkWin(testGameBoard, Disc.RED));
  }

  @Test
  public void checkWin_AscendingDiagonalConnect_win() {
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(2, Disc.GREEN);
    testGameBoard.dropDisc(2, Disc.RED);
    testGameBoard.dropDisc(3, Disc.GREEN);
    testGameBoard.dropDisc(3, Disc.GREEN);
    testGameBoard.dropDisc(3, Disc.RED);
    testGameBoard.dropDisc(4, Disc.GREEN);
    testGameBoard.dropDisc(4, Disc.GREEN);
    testGameBoard.dropDisc(4, Disc.GREEN);
    testGameBoard.dropDisc(4, Disc.RED);

    Assert.assertTrue(testJudge.checkWin(testGameBoard, Disc.RED));
  }

  @Test
  public void checkWin_DescendingDiagonalConnect_win() {
    testGameBoard.dropDisc(1, Disc.GREEN);
    testGameBoard.dropDisc(1, Disc.GREEN);
    testGameBoard.dropDisc(1, Disc.GREEN);
    testGameBoard.dropDisc(1, Disc.RED);
    testGameBoard.dropDisc(2, Disc.GREEN);
    testGameBoard.dropDisc(2, Disc.GREEN);
    testGameBoard.dropDisc(2, Disc.RED);
    testGameBoard.dropDisc(3, Disc.GREEN);
    testGameBoard.dropDisc(3, Disc.RED);
    testGameBoard.dropDisc(4, Disc.RED);

    Assert.assertTrue(testJudge.checkWin(testGameBoard, Disc.RED));
  }

}
