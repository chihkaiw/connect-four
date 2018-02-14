package connect;

import java.util.Scanner;

import connect.constant.Const;
import connect.model.Board;
import connect.model.Disc;
import connect.model.Player;
import connect.utils.Judge;

public class App {
  private static final int NUMBER_OF_ROWS = 6;
  private static final int NUMBER_OF_COLUMNS = 7;
  private static final int NUMBER_OF_PLAYERS = 2;
  private static final int START_PLAYER = 0;

  private int currentPlayerCounter;
  private Scanner scanner;
  private Judge judge;
  private Board gameBoard;
  private Player[] players;

  public App() {
    scanner = new Scanner(System.in);
    judge = new Judge();
    gameBoard = new Board(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    players = new Player[NUMBER_OF_PLAYERS];
    players[0] = new Player("1", Disc.RED);
    players[1] = new Player("2", Disc.GREEN);
    currentPlayerCounter = START_PLAYER;
  }

  public static void main(String[] args) {
    App app = new App();
    if (app.readyForPlay()) {
      app.play();
    }
  }

  /**
   * Check initialization is completed or not.
   *
   * @return true if initialization is done and ready for play, otherwise return false.
   */
  private boolean readyForPlay() {
    return (null != scanner && null != judge && null != gameBoard && null != players
        && players.length == NUMBER_OF_PLAYERS);
  }

  /**
   * Function for starting the match.
   */
  private void play() {
    matchStart();
    Player winner = null;
    while (winner == null && !gameBoard.isBoardFull()) {
      winner = action();
      currentPlayerCounter = (currentPlayerCounter + 1) % 2;
    }
    matchResult(winner);
  }

  /**
   * Function for player's action.
   *
   * @return current player if it wins, otherwise null.
   */
  private Player action() {
    Player currentPlayer = players[currentPlayerCounter];
    int inputColumn = getUserInput(currentPlayer);
    gameBoard.dropDisc(inputColumn, currentPlayer.getDisc());
    gameBoard.showBoard();
    return judge.checkWin(gameBoard, currentPlayer.getDisc()) ? currentPlayer : null;
  }

  /**
   * Get user's input of selecting column.
   *
   * @param currentPlayer
   * @return column number.
   */
  private int getUserInput(Player currentPlayer) {
    int inputAsInt = 0;
    announceChooseColumn(currentPlayer);

    outerLoop: while (true) {
      while (!scanner.hasNextInt()) {
        announcement(Const.INPUT_NOT_NUMBER);
        announceChooseColumn(currentPlayer);
        scanner.next();
      }
      inputAsInt = scanner.nextInt();

      if (inputAsInt < 1 || inputAsInt > NUMBER_OF_COLUMNS) {
        announcement(String.format(Const.INPUT_OVER_BOUNDARY, NUMBER_OF_COLUMNS));
        announceChooseColumn(currentPlayer);
      } else if (gameBoard.isColumnsFull(inputAsInt)) {
        announcement(String.format(Const.INPUT_COLUMN_IS_FULL, inputAsInt));
        announceChooseColumn(currentPlayer);
      } else {
        break outerLoop;
      }
      continue;
    }
    return inputAsInt;
  }

  /**
   * Announcing the beginning of the match.
   */
  private void matchStart() {
    announcement(Const.GAME_START);
    gameBoard.showBoard();
  }

  /**
   * Announcing the result of the match.
   *
   * @param winner
   */
  private void matchResult(Player winner) {
    gameBoard.showBoard();
    if (winner == null) {
      System.out.println(Const.WINNER_NO_ONE);
    } else {
      System.out.println(String.format(Const.WINNER_PLAYER, winner.getName()));
    }
  }

  private void announcement(String text) {
    System.out.println(text);
  }

  private void announceChooseColumn(Player player) {
    System.out.print(
        String.format(Const.INPUT_CHOOSE_COLUMN, player.getName(), player.getDisc().toString()));
  }
}

