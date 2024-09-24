import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalculatorApp implements ActionListener {

    private double num1 = 0, num2 = 0, result = 0;
    private int calculation;
    private boolean start = true;

    private JFrame frame = new JFrame("Calculator");
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField();
    private JRadioButton onRadioButton = new JRadioButton("on");
    private JRadioButton offRadioButton = new JRadioButton("off");
    private JButton[] numberButtons = new JButton[10];
    private JButton buttonDot = new JButton(".");
    private JButton buttonClear = new JButton("C");
    private JButton buttonDelete = new JButton("DEL");
    private JButton buttonEqual = new JButton("=");
    private JButton buttonMul = new JButton("x");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonSquare = new JButton("x²");
    private JButton buttonReciprocal = new JButton("1/x");
    private JButton buttonSqrt = new JButton("√");

    public CalculatorApp() {
        prepareGui();
        addComponents();
        addActionEvent();
    }

    public void prepareGui() {
        frame.setSize(305, 510);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(false);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        onRadioButton.setFocusable(false);
        frame.add(onRadioButton);

        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        offRadioButton.setFocusable(false);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        int x = 10, y = 230;
        for (int i = 1; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(x, y, 60, 40);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setFocusable(false);
            frame.add(numberButtons[i]);
            x += 70;
            if (i % 3 == 0) {
                x = 10;
                y += 60;
            }
        }

        numberButtons[0] = new JButton("0");
        numberButtons[0].setBounds(10, 410, 130, 40);
        numberButtons[0].setFont(new Font("Arial", Font.BOLD, 20));
        numberButtons[0].setFocusable(false);
        frame.add(numberButtons[0]);

        buttonDot.setBounds(150, 410, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDot.setFocusable(false);
        frame.add(buttonDot);

        buttonEqual.setBounds(220, 350, 60, 100);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        buttonEqual.setFocusable(false);
        frame.add(buttonEqual);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        buttonDiv.setFocusable(false);
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSqrt.setFocusable(false);
        frame.add(buttonSqrt);

        buttonMul.setBounds(220, 230, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(new Color(239, 188, 2));
        buttonMul.setFocusable(false);
        frame.add(buttonMul);

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        buttonMinus.setFocusable(false);
        frame.add(buttonMinus);

        buttonPlus.setBounds(220, 290, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        buttonPlus.setFocusable(false);
        frame.add(buttonPlus);

        buttonSquare.setBounds(80, 170, 60, 40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSquare.setFocusable(false);
        frame.add(buttonSquare);

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        buttonReciprocal.setFocusable(false);
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        buttonDelete.setFocusable(false);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        buttonClear.setFocusable(false);
        frame.add(buttonClear);
    }

    public void addActionEvent() {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonEqual.addActionListener(this);

        for (JButton button : numberButtons) {
            button.addActionListener(this);
        }

        buttonDot.addActionListener(this);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == onRadioButton) {
            enable();
        } else if (source == offRadioButton) {
            disable();
        } else if (source == buttonClear) {
            label.setText("");
            textField.setText("");
            start = true;
        } else if (source == buttonDelete) {
            int length = textField.getText().length();
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(length - 1);
                textField.setText(back.toString());
            }
            if (textField.getText().isEmpty()) {
                label.setText("");
            }
        } else if (source == buttonDot) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == buttonEqual) {
            num2 = Double.parseDouble(textField.getText());
            try {
                switch (calculation) {
                    case 1: // Addition
                        result = num1 + num2;
                        break;
                    case 2: // Subtraction
                        result = num1 - num2;
                        break;
                    case 3: // Multiplication
                        result = num1 * num2;
                        break;
                    case 4: // Division
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
            label.setText("");
            start = true;
        } else if (source == buttonSqrt) {
            try {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
            label.setText("");
            start = true;
        } else if (source == buttonSquare) {
            try {
                num1 = Double.parseDouble(textField.getText());
                result = num1 * num1;
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
            label.setText("");
            start = true;
        } else if (source == buttonReciprocal) {
            try {
                num1 = Double.parseDouble(textField.getText());
                if (num1 != 0) {
                    result = 1 / num1;
                    textField.setText(String.valueOf(result));
                } else {
                    textField.setText("Error");
                }
            } catch (Exception ex) {
                textField.setText("Error");
            }
            label.setText("");
            start = true;
        } else {
            for (int i = 0; i < numberButtons.length; i++) {
                if (source == numberButtons[i]) {
                    if (start) {
                        textField.setText(String.valueOf(i));
                        start = false;
                    } else {
                        textField.setText(textField.getText() + i);
                    }
                }
            }

            if (source == buttonPlus) {
                num1 = Double.parseDouble(textField.getText());
                calculation = 1;
                textField.setText("");
                label.setText(num1 + "+");
                start = true;
            } else if (source == buttonMinus) {
                num1 = Double.parseDouble(textField.getText());
                calculation = 2;
                textField.setText("");
                label.setText(num1 + "-");
                start = true;
            } else if (source == buttonMul) {
                num1 = Double.parseDouble(textField.getText());
                calculation = 3;
                textField.setText("");
                label.setText(num1 + "*");
                start = true;
            } else if (source == buttonDiv) {
                num1 = Double.parseDouble(textField.getText());
                calculation = 4;
                textField.setText("");
                label.setText(num1 + "/");
                start = true;
            }
        }
    }

    public void enable() {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        for (JButton button : numberButtons) {
            button.setEnabled(true);
        }
    }

    public void disable() {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        buttonClear.setEnabled(false);
        buttonDelete.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonDot.setEnabled(false);
        buttonEqual.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonReciprocal.setEnabled(false);
        buttonSqrt.setEnabled(false);
        buttonSquare.setEnabled(false);
        for (JButton button : numberButtons) {
            button.setEnabled(false);
        }
    }
}
