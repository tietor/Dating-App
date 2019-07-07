package ch.bbw;

import javax.validation.constraints.NotNull;

public class Frau extends User {
  @NotNull(message = "Bitte das Feld ausfüllen")
  private int hueftumfang;

  public int getHueftumfang() {
    return hueftumfang;
  }

  public void setHueftumfang(int hueftumfang) {
    this.hueftumfang = hueftumfang;
  }
}
