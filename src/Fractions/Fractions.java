package src.Fractions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.Character;

import src.gui;

public class Fractions {
  public static boolean isNegativeNumerator, isNegativeDenominator;
  public static int firstWhole, firstNum, firstDenom, secondWhole, secondNum, secondDenom;
  public static int newWhole, newNumerator, newDenominator, numRemainder, denomRemainder;
  public static int w, n, d;
  public static String error, finalFraction;
  public static int errorNum;

  public Fractions(int whole, int num, int denom) {
    w = whole;
    n = num;
    d = denom;
  }

  public static void setErrorNum(int n) {
    errorNum = n;
  }

  public static void setFinalFraction(String text) {
    finalFraction = text;
  }

  public static void setWholeNumber(int whole) {
    w = whole;
  }

  public static void setNumerator(int numerator) {
    n = numerator;
  }

  public static void setDenominator(int denominator) {
    d = denominator;
  }

  public static void setNewWhole(int n) {
    newWhole = n;
  }

  public static void setNewNumerator(int n) {
    newNumerator = n;
  }

  public static void setNewDenominator(int n) {
    newDenominator = n;
  }

  public static void setNumRemainder(int n) {
    numRemainder = n;
  }

  public static void setDenomRemainder(int n) {
    denomRemainder = n;
  }

  public static void setFirstFraction() {
    if (w != 0) {
      firstWhole = w;
      setWholeNumber(0);
    } else {
      firstWhole = 0;
    }
    firstNum = n;
    firstDenom = d;
  }

  public static void setSecondFraction() {
    if (w != 0) {
      secondWhole = w;
      setWholeNumber(0);
    } else {
      secondWhole = 0;
    }
    secondNum = n;
    secondDenom = d;
  }

  static int turnToNegative(int n) {
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
        setNewWhole(turnToNegative(positiveWhole));
      } else {
        setNewWhole(newNumerator / newDenominator);
      }
      setNewNumerator(newNumerator % newDenominator);
      if (newWhole == 0) {
        setFinalFraction(title + newNumerator + "/" + newDenominator);
      } else if (newNumerator == 0 && newWhole > 0) {
        setFinalFraction(title + newWhole + "/" + newDenominator + " or " + newWhole);
      } else {
        setFinalFraction(title + newWhole + " " + newNumerator + "/" + newDenominator);
      }
    } else if (newNumerator == newDenominator) {
      setFinalFraction(title + newNumerator + "/" + newDenominator + " or " + "1");
    } else if (newDenominator == 1){
      setFinalFraction(title + newNumerator + "/" + newDenominator + " or " + newNumerator);
    } else if (isNegativeDenominator) {
      newDenominator = Math.abs(newDenominator);
      setFinalFraction(title + "-" + newNumerator + "/" + newDenominator);
    } else {
      if (isNegativeNumerator) {
        newNumerator = turnToNegative(newNumerator);
      }
      setFinalFraction(title + newNumerator + "/" + newDenominator);
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
    int whole = 0, numerator = 0, denominator = 0, tempIndex = 0;
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
            whole = Integer.parseInt(wholeArray.stream().map(Object::toString).collect(Collectors.joining("")));
            if (whole == 0) {
              setErrorNum(1);
              error = "Whole number SHOULD NOT BE ZERO";
            }
          } catch (NumberFormatException e) {
            numberFormatErrorHandler();
          } catch (Exception e) {
            setErrorNum(1);
            error = "Something went wrong. If it is not responding, restart the app";
            gui.firstFractionField.setText("");
            gui.secondFractionField.setText("");
          }
          setWholeNumber(whole);
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
          numerator = Integer.parseInt(numArray.stream().map(Object::toString).collect(Collectors.joining("")));
        } catch (NumberFormatException e) {
          numberFormatErrorHandler();
        } catch (Exception e) {
          setErrorNum(1);
          error = "Something went wrong. If it is not responding, restart the app";
          gui.firstFractionField.setText("");
          gui.secondFractionField.setText("");
        }
        setNumerator(numerator);
        break;
      }
    }

    for (int k = tempIndex; k < x.length; k++) {
      denomArray.add(x[k]);
      try {
        denominator = Integer.parseInt(denomArray.stream().map(Object::toString).collect(Collectors.joining("")));
        if (denominator == 0) {
          setErrorNum(1);
          error = "Denominator cannot be ZERO";
        }
      } catch (NumberFormatException e) {
        numberFormatErrorHandler();
      } catch (Exception e) {
        setErrorNum(1);
        error = "Something went wrong. If it is not responding, restart the app";
        gui.firstFractionField.setText("");
        gui.secondFractionField.setText("");
      }
      setDenominator(denominator);
    }
  }

  static void numberFormatErrorHandler() {
    setErrorNum(1);
    error = "Enter a number";
    gui.firstFractionField.setText("");
    gui.secondFractionField.setText("");
  }
}
