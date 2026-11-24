package demo;

import practice.ValidParenthesesStack;

/** A demo of ValidParenthesesStack on the two strings the notes trace. */
public final class ValidParenthesesStackDemo {

  private ValidParenthesesStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Three pairs nested inside each other. Expect true.
    String nested = "{[()]}";
    System.out.println(nested + " is valid: " + ValidParenthesesStack.isValid(nested));

    // The brackets close in the wrong order. Expect false.
    String crossed = "([)]";
    System.out.println(crossed + " is valid: " + ValidParenthesesStack.isValid(crossed));
  }
}
