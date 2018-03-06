package connect.model;

public enum PlayerInputType {
    UNDO("u"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7");

      private final String value;

      PlayerInputType(String value) {
        this.value = value;
      }

      public String getValue() {
        return value;
      }
}
