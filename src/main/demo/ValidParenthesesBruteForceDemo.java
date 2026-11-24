package demo;

import practice.ValidParenthesesBruteForce;

/** A demo of ValidParenthesesBruteForce on the two strings the notes trace. */
public final class ValidParenthesesBruteForceDemo {

  private ValidParenthesesBruteForceDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Three pairs nested inside each other. Expect true.
    String nested = "{[()]}";
    System.out.println(nested + " is valid: " + ValidParenthesesBruteForce.isValid(nested));

    // The brackets close in the wrong order. Expect false.
    String crossed = "([)]";
    System.out.println(crossed + " is valid: " + ValidParenthesesBruteForce.isValid(crossed));
  }
}
