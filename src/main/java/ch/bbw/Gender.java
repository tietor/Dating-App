package ch.bbw;

public class Gender {

  private static Gender gender;

  private Gender() {
  }

  public static Gender getInstance() {
    if (gender == null) {
      gender = new Gender();
    }
    return gender;
  }

}
