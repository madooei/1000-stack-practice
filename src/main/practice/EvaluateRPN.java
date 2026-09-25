package practice;

import stack.ArrayStack;
import stack.Stack;

/** Solutions to the Evaluate Reverse Polish Notation problem. */
public final class EvaluateRPN {

  private EvaluateRPN() {
    // This class should not be instantiated!
  }

  // Returns the value of the expression. Assumes tokens is a valid RPN
  // expression: each token is an integer or one of the operators +, -, *, /.
  public static int evalRPN(String[] tokens) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // The brute-force solution. Returns the value of the expression. Assumes
  // tokens is a valid RPN expression, as for evalRPN.
  public static int evalRPNBruteForce(String[] tokens) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Removes list[index] from the first size elements of list and returns the
  // new size. Pre: 0 <= index < size.
  private static int removeAt(String[] list, int size, int index) {
    for (int k = index; k < size - 1; k++) {
      list[k] = list[k + 1];
    }
    return size - 1;
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
