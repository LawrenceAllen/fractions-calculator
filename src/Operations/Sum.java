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

  static void likeFractions() {
    Fractions.setNewNumerator(Fractions.firstNum + Fractions.secondNum);
    Fractions.setNewDenominator(Fractions.firstDenom);
  }

  static void unlikeFractions() {
    Fractions.setNewNumerator((Fractions.firstNum * Fractions.secondDenom) + (Fractions.secondNum * Fractions.firstDenom));
    Fractions.setNewDenominator(Fractions.firstDenom * Fractions.secondDenom);
  }

}
