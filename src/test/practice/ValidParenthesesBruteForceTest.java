package practice;

/** Runs the valid-parentheses scenarios against the brute-force solution. */
public class ValidParenthesesBruteForceTest extends ValidParenthesesTest {

  @Override
  protected boolean isValid(String s) {
    return ValidParentheses.isValidBruteForce(s);
  }
}
