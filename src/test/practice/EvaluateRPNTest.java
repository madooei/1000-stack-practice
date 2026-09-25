package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The scenarios for the Evaluate Reverse Polish Notation problem. A concrete
 * subclass supplies evalRPN() to pick the solution under test.
 */
public abstract class EvaluateRPNTest {

  // Calls the solution under test.
  protected abstract int evalRPN(String[] tokens);

  @Test
  public void additionThenMultiplication() {
    assertEquals(12, evalRPN(new String[] {"2", "1", "+", "4", "*"}));
  }

  @Test
  public void integerDivisionTruncatesTowardZero() {
    assertEquals(6, evalRPN(new String[] {"4", "13", "5", "/", "+"}));
  }

  @Test
  public void singleNumberIsAValidExpression() {
    assertEquals(42, evalRPN(new String[] {"42"}));
  }

  @Test
  public void subtractionKeepsOperandOrder() {
    assertEquals(4, evalRPN(new String[] {"7", "3", "-"}));
  }

  @Test
  public void negativeNumberTokenIsNotAnOperator() {
    assertEquals(6, evalRPN(new String[] {"-3", "9", "+"}));
  }

  @Test
  public void divisionWithNegativeOperandTruncatesTowardZero() {
    assertEquals(-3, evalRPN(new String[] {"7", "-2", "/"}));
  }
}
