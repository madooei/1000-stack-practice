package practice;

/** Runs the valid-parentheses scenarios against the stack solution. */
public class ValidParenthesesStackTest extends ValidParenthesesTest {

  @Override
  protected boolean isValid(String s) {
    return ValidParentheses.isValid(s);
  }
}
