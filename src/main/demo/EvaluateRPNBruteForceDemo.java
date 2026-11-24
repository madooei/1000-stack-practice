package demo;

import java.util.Arrays;
import practice.EvaluateRPNBruteForce;

/** A demo of EvaluateRPNBruteForce on two expressions from the notes. */
public final class EvaluateRPNBruteForceDemo {

  private EvaluateRPNBruteForceDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // (2 + 1) * 4. Expect 12.
    String[] first = {"2", "1", "+", "4", "*"};
    System.out.println(Arrays.toString(first) + " = " + EvaluateRPNBruteForce.evalRPN(first));

    // 4 + (13 / 5), with integer division. Expect 6.
    String[] second = {"4", "13", "5", "/", "+"};
    System.out.println(Arrays.toString(second) + " = " + EvaluateRPNBruteForce.evalRPN(second));
  }
}
