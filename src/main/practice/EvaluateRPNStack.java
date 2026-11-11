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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
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
