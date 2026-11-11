package practice;

/** Practice problem: check that brackets are balanced by removing adjacent pairs. */
public final class ValidParenthesesBruteForce {

  private ValidParenthesesBruteForce() {
    // This class should not be instantiated!
  }

  // Returns true if s is valid. Assumes s contains only the characters ()[]{}.
  public static boolean isValid(String s) {
    boolean changed = true;
    while (changed) {
      int lengthBefore = s.length();
      s = s.replace("()", "");
      s = s.replace("[]", "");
      s = s.replace("{}", "");
      changed = s.length() < lengthBefore;
    }
    return s.isEmpty();
  }
}
