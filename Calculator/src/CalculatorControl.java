import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

class CalculatorControl extends Panel {
    protected JTextField expression;
    protected boolean isFirst;
    protected int lastChar;

    CalculatorControl() {
        expression = new JTextField("0");
    }

    public void getLastChar() {
        isFirst = expression.getText().length() == 1;

        char ch = expression.getText().charAt(expression.getText().length() - 1);
        if (ch == '0') lastChar = 0;
        else if (ch > '0' && ch <= '9') lastChar = 1;
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') lastChar = 2;
        else {
            clear();
            lastChar = 0;
            isFirst = true;
        }
    }

    public void clear() {
        expression.setText("0");
    }

    public void deleteLastChar() {
        if (expression.getText().length() == 1)
            expression.setText("0");
        else expression.setText(expression.getText().substring(0, expression.getText().length() - 1));
    }

    ActionListener numberListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            getLastChar();
            if (lastChar == 0 && isFirst) {
                if (button.getText() == "0") return;
                else {
                    expression.setText(button.getText());
                }
            } else expression.setText(expression.getText() + button.getText());
        }
    };

    ActionListener signListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            getLastChar();
            if (lastChar == 2) {
                deleteLastChar();
                expression.setText(expression.getText() + button.getText());
            } else {
                expression.setText(expression.getText() + button.getText());
            }
        }
    };

    ActionListener backspaceListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (expression.getText().charAt(expression.getText().length() - 1) == '!') clear();
            else deleteLastChar();
        }
    };

    ActionListener equalListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getLastChar();
            if (lastChar == 2) expression.setText("表达式错误！");
            else {
                CalculatorModel calcluatorModel = new CalculatorModel(expression.getText());
                expression.setText(calcluatorModel.calculatorExpression());
            }
        }
    };

    ActionListener clearListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            clear();
        }
    };
}
