package src.Operations;

import src.Fractions.Fractions;

public class Product {

  public static void fraction() {
    Fractions.convertToFraction();
    Fractions.setNewNumerator(Fractions.firstNum * Fractions.secondNum);
    Fractions.setNewDenominator(Fractions.firstDenom * Fractions.secondDenom);
    Fractions.simplifyFraction();
    Fractions.printAnswer("Product is ");
  }
}

