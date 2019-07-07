package ch.bbw;

import javax.validation.constraints.NotNull;

public class Mann extends User{
  @NotNull(message = "Dieses Feld muss auch ausgefüllt werden")
  private int bizeps;

  public int getBizeps() {
    return bizeps;
  }

  public void setBizeps(int bizeps) {
    this.bizeps = bizeps;
  }
}
