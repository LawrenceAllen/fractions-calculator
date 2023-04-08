package src.Operations;

import src.Fractions.Fractions;

public class Quotient {

  public static void fraction() {
    Fractions.convertToFraction();
    Fractions.setNewNumerator(Fractions.firstNum * Fractions.secondDenom);
    Fractions.setNewDenominator(Fractions.firstDenom * Fractions.secondNum);
    Fractions.simplifyFraction();
    Fractions.printAnswer("Quotient is ");
  }
}

