package src.Operations;

import src.Fractions.Fractions;

public class Difference {

  public static void fraction() {
    Fractions.convertToFraction();
    if (Fractions.isLikeFractions()) {
      likeFractions();
    } else {
      unlikeFractions();
    } 
    Fractions.simplifyFraction();
    Fractions.printAnswer("Difference is ");
  }

  private static void likeFractions() {
    Fractions.setNewNumerator(Fractions.getFirstNum() - Fractions.getSecondNum());
    Fractions.setNewDenominator(Fractions.getFirstDenom());
  }

  private static void unlikeFractions() {
    Fractions.setNewNumerator((Fractions.getFirstNum() * Fractions.getSecondDenom()) - (Fractions.getSecondNum() * Fractions.getFirstDenom()));
    Fractions.setNewDenominator(Fractions.getFirstDenom() * Fractions.getSecondDenom());
  }
}

