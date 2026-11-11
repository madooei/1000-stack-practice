package practice;

import stack.LinkedStack;
import stack.Stack;

/** Practice problem: check that brackets are balanced by matching them with a stack. */
public final class ValidParenthesesStack {

  private ValidParenthesesStack() {
    // This class should not be instantiated!
  }

  // Returns true if s is valid. Assumes s contains only the characters ()[]{}.
  public static boolean isValid(String s) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns true if open and close are a matched pair of the same type.
  private static boolean matches(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '[' && close == ']')
        || (open == '{' && close == '}');
  }
}
