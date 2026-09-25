package practice;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The contract test suite for the MinStack ADT, written against the MinStack
 * interface alone. A concrete subclass supplies createMinStack() to pick the
 * implementation.
 */
public abstract class MinStackTest {

  private MinStack minStack;

  protected abstract MinStack createMinStack();

  @BeforeEach
  public void setup() {
    minStack = createMinStack();
  }

  @Test
  public void getMinOnEmptyStackThrows() {
    try {
      minStack.getMin();
      fail("expected NoSuchElementException when calling getMin on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void topOnEmptyStackThrows() {
    try {
      minStack.top();
      fail("expected NoSuchElementException when calling top on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void popOnEmptyStackThrows() {
    try {
      minStack.pop();
      fail("expected NoSuchElementException when popping an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void getMinOfSingleItem() {
    minStack.push(5);
    assertEquals(5, minStack.getMin());
  }

  @Test
  public void pushingASmallerItemBecomesTheMinimum() {
    minStack.push(5);
    minStack.push(2);
    assertEquals(2, minStack.getMin());
  }

  @Test
  public void pushingALargerItemKeepsTheMinimum() {
    minStack.push(5);
    minStack.push(2);
    minStack.push(7);
    assertEquals(2, minStack.getMin());
  }

  @Test
  public void poppingANonMinimumKeepsTheMinimum() {
    minStack.push(5);
    minStack.push(2);
    minStack.push(7);
    minStack.pop();
    assertEquals(2, minStack.getMin());
  }

  @Test
  public void poppingTheMinimumRecoversTheEarlierMinimum() {
    minStack.push(5);
    minStack.push(2);
    minStack.pop();
    assertEquals(5, minStack.getMin());
  }

  @Test
  public void poppingOneOfTwoEqualMinimaKeepsTheOther() {
    minStack.push(2);
    minStack.push(2);
    minStack.pop();
    assertEquals(2, minStack.getMin());
  }

  @Test
  public void poppingBothEqualMinimaRecoversTheEarlierMinimum() {
    minStack.push(5);
    minStack.push(2);
    minStack.push(2);
    minStack.pop();
    minStack.pop();
    assertEquals(5, minStack.getMin());
  }

  @Test
  public void topReturnsMostRecentlyPushedItem() {
    minStack.push(10);
    minStack.push(20);
    minStack.push(30);
    assertEquals(30, minStack.top());
  }

  @Test
  public void popRevealsThePreviousItem() {
    minStack.push(10);
    minStack.push(20);
    minStack.pop();
    assertEquals(10, minStack.top());
  }

  @Test
  public void poppingEveryItemLeavesStackEmpty() {
    minStack.push(10);
    minStack.push(20);
    minStack.push(30);
    minStack.pop();
    minStack.pop();
    minStack.pop();
    assertTrue(minStack.isEmpty());
  }

  @Test
  public void pushNullThrows() {
    try {
      minStack.push(null);
      fail("expected IllegalArgumentException when pushing null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
