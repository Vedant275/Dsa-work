import java.util.*;

/**
 * This program evaluates arithmetic expressions using two stacks:
 * one for operands (numbers) and another for operators (+, -, *, /).
 */

public class ArithmeticOperationsUsingStack {
    
    public static void performOperation(Stack<Integer> operands, Stack<Character> operators) {
        int b = operands.pop();
        int a = operands.pop();
        char op = operators.pop();
        int result = 0;

        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
        }

        operands.push(result);
    }

    public static void evaluate(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Ignore spaces
            if (ch == ' ') continue;

            // If digit, push to operand stack
            if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty()) {
                    char top = operators.peek();

                    // precedence check
                    if ((top == '*' || top == '/') && (ch == '+' || ch == '-')) {
                        performOperation(operands, operators);
                    } else {
                        break;
                    }
                }
                operators.push(ch);
            }

            // Handle parenthesis
            else if (ch == '(') {
                operators.push(ch);
            } 
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    performOperation(operands, operators);
                }
                operators.pop(); // remove '('
            }
        }

        // Remaining operations
        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        System.out.println("Result: " + operands.pop());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression:");
        String exp = sc.nextLine();

        evaluate(exp);
    }
}
