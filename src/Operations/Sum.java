package src.Operations;

import src.Fractions.Fractions;

public class Sum {

  public static void fraction() {
    Fractions.convertToFraction();
    if (Fractions.isLikeFractions()) {
      likeFractions();
    } else {
      unlikeFractions();
    } 
    Fractions.simplifyFraction();
    Fractions.printAnswer("Sum is ");
  }

  private static void likeFractions() {
    Fractions.setNewNumerator(Fractions.getFirstNum() + Fractions.getSecondNum());
    Fractions.setNewDenominator(Fractions.getFirstDenom());
  }

  private static void unlikeFractions() {
    Fractions.setNewNumerator((Fractions.getFirstNum() * Fractions.getSecondDenom()) + (Fractions.getSecondNum() * Fractions.getFirstNum()));
    Fractions.setNewDenominator(Fractions.getFirstDenom() * Fractions.getSecondDenom());
  }

}
