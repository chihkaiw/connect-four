package connect.model;

public enum Disc {
  NONE(" "), RED("R"), GREEN("G");

  private final String image;

  Disc(String image) {
    this.image = image;
  }

  public String getImage() {
    return image;
  }
}
