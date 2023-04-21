package src;

import src.Operations.Sum;
import src.Fractions.Fractions;
import src.Fractions.Inputs;
import src.Operations.Difference;
import src.Operations.Product;
import src.Operations.Quotient;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Box;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
  private static String firstInputFieldText, secondInputFieldText;
  private static JLabel answerLabel = new JLabel(" "); 
  private static JButton addButton = new JButton("Add");
  private static JButton subtractButton = new JButton("Subtract");
  private static JButton multiplyButton = new JButton("Multiply");
  private static JButton divideButton = new JButton("Divide"); 
  public static JTextField firstFractionField = new JTextField();
  public static JTextField secondFractionField = new JTextField();

  public static void fractionsGUI() {
    JFrame frame = new JFrame("Fractions Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(480, 200);
    frame.setResizable(false);

    JLabel firstFractionFieldLabel = new JLabel("First Fraction: ");
    JLabel secondFractionFieldLabel = new JLabel("Second Fraction: ");
    
    Dimension buttonDefaultDimension = new Dimension(90, 25);
    
    addButton.setPreferredSize(buttonDefaultDimension);
    subtractButton.setPreferredSize(buttonDefaultDimension);
    multiplyButton.setPreferredSize(buttonDefaultDimension);
    divideButton.setPreferredSize(buttonDefaultDimension);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    buttonsPanel.add(addButton);
    buttonsPanel.add(Box.createHorizontalStrut(5));
    buttonsPanel.add(subtractButton);
    buttonsPanel.add(Box.createHorizontalStrut(5));
    buttonsPanel.add(multiplyButton);
    buttonsPanel.add(Box.createHorizontalStrut(5));
    buttonsPanel.add(divideButton);

    JPanel mainContainer = new JPanel();
    mainContainer.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    mainContainer.add(firstFractionFieldLabel, gbc);
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    mainContainer.add(firstFractionField, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    mainContainer.add(secondFractionFieldLabel, gbc);
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    mainContainer.add(secondFractionField, gbc);
    gbc.insets = new Insets(10, 0, 10, 0);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 4;
    mainContainer.add(answerLabel, gbc);
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 4;
    mainContainer.add(buttonsPanel, gbc);

    frame.add(mainContainer);

    frame.setVisible(true);

    buttonClickEvents();
  }

  public static String getFirstTextFieldValue() {
    firstInputFieldText = firstFractionField.getText();
    return firstInputFieldText;
  }

  public static String getSecondTextFieldValue() {
    secondInputFieldText = secondFractionField.getText();
    return secondInputFieldText;
  }

  private static void setAnswer(String text) {
    answerLabel.setText(text);
  }

  private static void buttonClickEvents() {
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Inputs.getFractionValues();
        if (Inputs.getFirstInput() != null && Inputs.getSecondInput() != null) {
          if (Fractions.getErrorNum() < 1) {
            if (e.getSource() == addButton) {
              Sum.fraction();
            } else if (e.getSource() == subtractButton) {
              Difference.fraction();
            } else if (e.getSource() == multiplyButton) {
              Product.fraction();
            } else {
              Quotient.fraction();
            }
            answerLabel.setForeground(Color.BLACK);
            setAnswer(Fractions.getFinalFraction());
          } else if (Fractions.getErrorNum() == 2) {
            answerLabel.setForeground(Color.RED);
            setAnswer("Fraction format error");
            Fractions.setErrorNum(0);
          } else {
            answerLabel.setForeground(Color.RED);
            setAnswer(Fractions.getErrorMessage());
            Fractions.setErrorNum(0);
          }
        }
      }
    };

    addButton.addActionListener(actionListener);
    subtractButton.addActionListener(actionListener);
    multiplyButton.addActionListener(actionListener);
    divideButton.addActionListener(actionListener);
  }

}
