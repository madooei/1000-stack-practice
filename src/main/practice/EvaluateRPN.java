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

  // The brute-force solution. Returns the value of the expression. Assumes
  // tokens is a valid RPN expression, as for evalRPN.
  public static int evalRPNBruteForce(String[] tokens) {
    String[] list = new String[tokens.length];
    int size = tokens.length;
    for (int i = 0; i < tokens.length; i++) {
      list[i] = tokens[i];  // copy so we do not change the caller's array
    }

    while (size > 1) {
      int i = 0;
      while (!isOperator(list[i])) {
        i++;  // find the first operator
      }
      int a = Integer.parseInt(list[i - 2]);
      int b = Integer.parseInt(list[i - 1]);
      int result = apply(list[i], a, b);
      list[i - 2] = Integer.toString(result);
      size = removeAt(list, size, i);      // remove the operator first
      size = removeAt(list, size, i - 1);  // then the second operand
    }

    return Integer.parseInt(list[0]);
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
