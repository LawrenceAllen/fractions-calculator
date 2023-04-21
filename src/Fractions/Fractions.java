package src.Fractions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.Character;

import src.gui;

public class Fractions {
  private static int whole, numerator, denominator;
  private static boolean isNegativeNumerator, isNegativeDenominator;
  private static int firstWhole, firstNum, firstDenom, secondWhole, secondNum, secondDenom;
  private static int newWhole, newNumerator, newDenominator, numRemainder, denomRemainder;
  private static String errorMessage, finalFraction;
  private static int errorNum;

  public static String getErrorMessage() {
    return errorMessage;
  }

  public static void setErrorNum(int n) {
    errorNum = n;
  }

  public static int getErrorNum() {
    return errorNum;
  }

  public static String getFinalFraction() {
    return finalFraction;
  }

  public static int getFirstNum() {
    return firstNum;
  }

  public static int getSecondNum() {
    return secondNum;
  }

  public static int getFirstDenom() {
    return firstDenom;
  }

  public static int getSecondDenom() {
    return secondDenom;
  }

  public static void setNewNumerator(int n) {
    newNumerator = n;
  }

  public static void setNewDenominator(int n) {
    newDenominator = n;
  }

  public static void setFirstFraction() {
    if (whole != 0) {
      firstWhole = whole;
      whole = 0;
    } else {
      firstWhole = 0;
    }
    firstNum = numerator;
    firstDenom = denominator;
  }

  public static void setSecondFraction() {
    if (whole != 0) {
      secondWhole = whole;
      whole = 0;
    } else {
      secondWhole = 0;
    }
    secondNum = numerator;
    secondDenom = denominator;
  }

  private static int turnToNegative(int n) {
    int negative = (n - n) - n;
    return negative; 
  }

  public static void convertToFraction() {
    if (firstWhole != 0) {
      if (firstWhole < 0) {
        firstNum = turnToNegative((firstDenom * Math.abs(firstWhole)) + firstNum);
      } else {
        firstNum = (firstDenom * firstWhole) + firstNum;
      }
    }
    
    if (secondWhole != 0) {
      if (secondWhole < 0) {
        secondNum = turnToNegative((secondDenom * Math.abs(secondWhole)) + secondNum);
      } else {
        secondNum = (secondDenom * secondWhole) + secondNum;
      }
    }
  }

  public static void simplifyFraction() {
    if (newNumerator < 0) {
      isNegativeNumerator = true;
      newNumerator = Math.abs(newNumerator);
    }
    if (newDenominator < 0) {
      isNegativeDenominator = true;
      newDenominator = Math.abs(newDenominator);
    }
    numRemainder = newNumerator % 2;
    denomRemainder = newDenominator % 2;

    while (numRemainder != 1 && denomRemainder != 1) {
      newNumerator = newNumerator / 2;
      newDenominator = newDenominator / 2;
      numRemainder = newNumerator % 2;
      denomRemainder = newDenominator % 2;
    }
  }

  public static void printAnswer(String title) {
    if (newNumerator > newDenominator) {
      if (isNegativeNumerator) {
        int positiveWhole = (newNumerator / newDenominator);
        newWhole = turnToNegative(positiveWhole);
      } else {
        newWhole = (newNumerator / newDenominator);
      }
      setNewNumerator(newNumerator % newDenominator);
      if (newWhole == 0) {
        finalFraction = (title + newNumerator + "/" + newDenominator);
      } else if (newNumerator == 0 && newWhole > 0) {
        finalFraction = (title + newWhole + "/" + newDenominator + " or " + newWhole);
      } else {
        finalFraction = (title + newWhole + " " + newNumerator + "/" + newDenominator);
      }
    } else if (newNumerator == newDenominator) {
      finalFraction = (title + newNumerator + "/" + newDenominator + " or " + "1");
    } else if (newDenominator == 1){
      finalFraction = (title + newNumerator + "/" + newDenominator + " or " + newNumerator);
    } else if (isNegativeDenominator) {
      newDenominator = Math.abs(newDenominator);
      finalFraction = (title + "-" + newNumerator + "/" + newDenominator);
    } else {
      if (isNegativeNumerator) {
        newNumerator = turnToNegative(newNumerator);
      }
      finalFraction = (title + newNumerator + "/" + newDenominator);
    }
    isNegativeNumerator = false;
    isNegativeDenominator = false;
  }

  public static boolean isLikeFractions() {
    if (firstDenom == secondDenom) {
      return true;
    } else {
      return false;
    }
  }

  public static int fractionType(char[] x) {
    int spaceCount = 0, slashCount = 0;
    int firstChar = Character.getNumericValue(x[0]);
    char space = ' ';
    char slash = '/';

    int type = 0;

    for (char c : x) {
      if (c == space) {
        spaceCount += spaceCount + 1;
      } else if (c == slash) {
        slashCount += slashCount + 1;
      }
    }

    /* 
     * 0 - Not a Fraction/Wrong Format
     * 1 - Normal
     * 2 - Mixed
     */

    if (firstChar <= 0 || firstChar >= 0) {
      if (slashCount == 1) {
        type = 1;
        if (spaceCount == 1) {
          type = 2;
        }
      } else {
        type = 0;
      }
    }

    return type;
  }

  public static void getFractionValues(char[] x) {
    int wholeNumValue = 0, numeratorNumValue = 0, denominatorNumValue = 0, tempIndex = 0;
    char space = ' ';
    char slash = '/';

    Character w[] = new Character[0];
    Character n[] = new Character[0];
    Character d[] = new Character[0];
    ArrayList<Character> wholeArray = new ArrayList<Character>(Arrays.asList(w));
    ArrayList<Character> numArray = new ArrayList<Character>(Arrays.asList(n));
    ArrayList<Character> denomArray = new ArrayList<Character>(Arrays.asList(d));

    if (fractionType(x) == 2) {
      for (int i = 0; i < x.length; i++) {
        wholeArray.add(x[i]);
        if (x[i] == space) {
          tempIndex = i + 1;
          wholeArray.remove(wholeArray.size() - 1);
          try {
            wholeNumValue = Integer.parseInt(wholeArray.stream().map(Object::toString).collect(Collectors.joining("")));
            if (wholeNumValue == 0) {
              setErrorNum(1);
              errorMessage = "Whole number SHOULD NOT BE ZERO";
            }
          } catch (NumberFormatException e) {
            numberFormatErrorHandler();
          } catch (Exception e) {
            setErrorNum(1);
            errorMessage = "Something went wrong. If it is not responding, restart the app";
            gui.firstFractionField.setText("");
            gui.secondFractionField.setText("");
          }
          whole = wholeNumValue;
          break;
        }
      }
    }
    
    for (int j = tempIndex; j < x.length; j++) {
      numArray.add(x[j]);
      if (x[j] == slash) {
        tempIndex = j + 1;
        numArray.remove(numArray.size() - 1);
        try {
          numeratorNumValue = Integer.parseInt(numArray.stream().map(Object::toString).collect(Collectors.joining("")));
        } catch (NumberFormatException e) {
          numberFormatErrorHandler();
        } catch (Exception e) {
          setErrorNum(1);
          errorMessage = "Something went wrong. If it is not responding, restart the app";
          gui.firstFractionField.setText("");
          gui.secondFractionField.setText("");
        }
        numerator = numeratorNumValue;
        break;
      }
    }

    for (int k = tempIndex; k < x.length; k++) {
      denomArray.add(x[k]);
      try {
        denominatorNumValue = Integer.parseInt(denomArray.stream().map(Object::toString).collect(Collectors.joining("")));
        if (denominatorNumValue == 0) {
          setErrorNum(1);
          errorMessage = "Denominator cannot be ZERO";
        }
      } catch (NumberFormatException e) {
        numberFormatErrorHandler();
      } catch (Exception e) {
        setErrorNum(1);
        errorMessage = "Something went wrong. If it is not responding, restart the app";
        gui.firstFractionField.setText("");
        gui.secondFractionField.setText("");
      }
      denominator = denominatorNumValue;
    }
  }

  private static void numberFormatErrorHandler() {
    setErrorNum(1);
    errorMessage = "Wrong number format";
  }
}
