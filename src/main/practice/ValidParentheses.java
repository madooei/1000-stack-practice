package practice;

import stack.LinkedStack;
import stack.Stack;

/** Solutions to the valid-parentheses problem. */
public final class ValidParentheses {

  private ValidParentheses() {
    // This class should not be instantiated!
  }

  // Returns true if s is valid. Assumes s contains only the characters ()[]{}.
  public static boolean isValid(String s) {
    Stack<Character> stack = new LinkedStack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;  // a closing bracket with no opener
        }
        char open = stack.top();
        stack.pop();
        if (!matches(open, c)) {
          return false;  // closed by the wrong type
        }
      }
    }

    return stack.isEmpty();
  }

  // Returns true if open and close are a matched pair of the same type.
  private static boolean matches(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '[' && close == ']')
        || (open == '{' && close == '}');
  }

  // The brute-force solution. Returns true if s is valid. Assumes s contains only the characters ()[]{}.
  public static boolean isValidBruteForce(String s) {
    boolean changed = true;
    while (changed) {
      int lengthBefore = s.length();
      s = s.replace("()", "");
      s = s.replace("[]", "");
      s = s.replace("{}", "");
      changed = s.length() < lengthBefore;
    }
    return s.isEmpty();
  }
}
