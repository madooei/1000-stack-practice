package demo;

import java.util.Arrays;
import practice.EvaluateRPNStack;

/** A demo of EvaluateRPNStack on two expressions from the notes. */
public final class EvaluateRPNStackDemo {

  private EvaluateRPNStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // (2 + 1) * 4. Expect 12.
    String[] first = {"2", "1", "+", "4", "*"};
    System.out.println(Arrays.toString(first) + " = " + EvaluateRPNStack.evalRPN(first));

    // 4 + (13 / 5), with integer division. Expect 6.
    String[] second = {"4", "13", "5", "/", "+"};
    System.out.println(Arrays.toString(second) + " = " + EvaluateRPNStack.evalRPN(second));
  }
}
