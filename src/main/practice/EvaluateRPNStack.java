package practice;

import stack.ArrayStack;
import stack.Stack;

/** Practice problem: evaluate an RPN expression with a stack. */
public final class EvaluateRPNStack {

  private EvaluateRPNStack() {
    // This class should not be instantiated!
  }

  // Returns the value of the expression. Assumes tokens is a valid RPN
  // expression: each token is an integer or one of the operators +, -, *, /.
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new ArrayStack<>();

    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];

      if (isOperator(token)) {
        int b = stack.top();  // the most recent number is the second operand
        stack.pop();
        int a = stack.top();
        stack.pop();
        stack.push(apply(token, a, b));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.top();
  }

  // Returns true if the token is one of the four operators.
  private static boolean isOperator(String token) {
    return token.equals("+") || token.equals("-")
        || token.equals("*") || token.equals("/");
  }

  // Pre: operator is one of "+", "-", "*", "/".
  private static int apply(String operator, int a, int b) {
    if (operator.equals("+")) return a + b;
    if (operator.equals("-")) return a - b;
    if (operator.equals("*")) return a * b;
    return a / b;  // the operator is "/"
  }
}
