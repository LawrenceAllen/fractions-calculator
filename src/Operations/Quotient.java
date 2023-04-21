package src.Operations;

import src.Fractions.Fractions;

public class Quotient {

  public static void fraction() {
    Fractions.convertToFraction();
    Fractions.setNewNumerator(Fractions.getFirstNum() * Fractions.getSecondDenom());
    Fractions.setNewDenominator(Fractions.getFirstDenom() * Fractions.getSecondNum());
    Fractions.simplifyFraction();
    Fractions.printAnswer("Quotient is ");
  }
}

