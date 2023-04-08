package src.Fractions;

import src.gui; 

public class Inputs {
  public static String firstInput;
  public static String secondInput;

  public Inputs(String firstNumber, String secondNumber) {
    firstInput = firstNumber;
    secondInput = secondNumber;
  }

  public static void setFirstInput(String newValue) {
    firstInput = newValue;
  }

  public static void setSecondInput(String newValue) {
    secondInput = newValue;
  }

  public static void getFirstInput() {
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

  public static void getSecondInput() {
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

  public static void getInputs() {
    getFirstInput();
    getSecondInput();
  }

}
