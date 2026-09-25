package practice;

/** Runs the Evaluate Reverse Polish Notation scenarios against the brute-force solution. */
public class EvaluateRPNBruteForceTest extends EvaluateRPNTest {

  @Override
  protected int evalRPN(String[] tokens) {
    return EvaluateRPN.evalRPNBruteForce(tokens);
  }
}
