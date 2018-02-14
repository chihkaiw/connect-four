package connect.model;

public class Player {
  private String name;
  private Disc disc;

  public Player(String name, Disc disc) {
    this.name = name;
    this.disc = disc;
  }

  /**
   * Get name of player.
   *
   * @return name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the Disc of the player own.
   *
   * @return the Disc of the player own.
   */
  public Disc getDisc() {
    return disc;
  }
}

