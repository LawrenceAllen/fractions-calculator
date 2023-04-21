package src.Fractions;

import src.gui; 

public class Inputs {
  private static String firstInput;
  private static String secondInput;

  public static void setFirstInput(String newValue) {
    firstInput = newValue;
  }

  public static String getFirstInput() {
    return firstInput;
  }

  public static void setSecondInput(String newValue) {
    secondInput = newValue;
  }

  public static String getSecondInput() {
    return secondInput;
  }

  private static void getFirstFraction() {
    if (!gui.getFirstTextFieldValue().isEmpty()) {
      setFirstInput(gui.getFirstTextFieldValue());
      char[] firstInputArray = firstInput.toCharArray();
      if (Fractions.fractionType(firstInputArray) == 0) {
        Fractions.setErrorNum(2);
        gui.firstFractionField.setText("");
      } else {
        Fractions.getFractionValues(firstInputArray);
        Fractions.setFirstFraction();
      }
    }
  }

  private static void getSecondFraction() {
    if (!gui.getSecondTextFieldValue().isEmpty()) {
      setSecondInput(gui.getSecondTextFieldValue());
      char[] secondInputArray = secondInput.toCharArray();
      if (Fractions.fractionType(secondInputArray) == 0) {
        Fractions.setErrorNum(2);
        gui.secondFractionField.setText("");
      } else {
        Fractions.getFractionValues(secondInputArray);
        Fractions.setSecondFraction();
      }
    }
  }

  public static void getFractionValues() {
    getFirstFraction();
    getSecondFraction();
  }

}
