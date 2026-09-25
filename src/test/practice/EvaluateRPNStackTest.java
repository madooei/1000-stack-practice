package practice;

/** Runs the Evaluate Reverse Polish Notation scenarios against the stack solution. */
public class EvaluateRPNStackTest extends EvaluateRPNTest {

  @Override
  protected int evalRPN(String[] tokens) {
    return EvaluateRPN.evalRPN(tokens);
  }
}
