package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The scenarios for the valid-parentheses problem. A concrete subclass supplies
 * isValid() to pick the solution under test.
 */
public abstract class ValidParenthesesTest {

  // Calls the solution under test.
  protected abstract boolean isValid(String s);

  @Test
  public void emptyStringIsValid() {
    assertTrue(isValid(""));
  }

  @Test
  public void singleOpenerIsInvalid() {
    assertFalse(isValid("("));
  }

  @Test
  public void closerBeforeItsOpenerIsInvalid() {
    assertFalse(isValid(")("));
  }

  @Test
  public void onePairIsValid() {
    assertTrue(isValid("()"));
  }

  @Test
  public void threePairsOneAfterAnotherAreValid() {
    assertTrue(isValid("()[]{}"));
  }

  @Test
  public void nestedPairsAreValid() {
    assertTrue(isValid("{[()]}"));
  }

  @Test
  public void closingWithTheWrongTypeIsInvalid() {
    assertFalse(isValid("(]"));
  }

  @Test
  public void openerThatIsNeverClosedIsInvalid() {
    assertFalse(isValid("(()"));
  }

  @Test
  public void crossedPairsAreInvalid() {
    assertFalse(isValid("([)]"));
  }
}
