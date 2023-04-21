package src.Operations;

import src.Fractions.Fractions;

public class Product {

  public static void fraction() {
    Fractions.convertToFraction();
    Fractions.setNewNumerator(Fractions.getFirstNum() * Fractions.getSecondNum());
    Fractions.setNewDenominator(Fractions.getFirstDenom() * Fractions.getSecondDenom());
    Fractions.simplifyFraction();
    Fractions.printAnswer("Product is ");
  }
}

