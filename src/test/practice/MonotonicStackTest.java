package practice;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The contract test suite for the MonotonicStack ADT, written against the
 * MonotonicStack interface alone. A concrete subclass supplies
 * createMonotonicStack() to pick the implementation.
 */
public abstract class MonotonicStackTest {

  private MonotonicStack stack;

  protected abstract MonotonicStack createMonotonicStack();

  @BeforeEach
  public void setup() {
    stack = createMonotonicStack();
  }

  @Test
  public void newStackIsEmpty() {
    assertTrue(stack.isEmpty());
  }

  @Test
  public void topOnEmptyStackThrows() {
    try {
      stack.top();
      fail("expected NoSuchElementException when calling top on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void popOnEmptyStackThrows() {
    try {
      stack.pop();
      fail("expected NoSuchElementException when popping an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void pushMakesStackNonEmpty() {
    stack.push(5);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void topReturnsPushedItem() {
    stack.push(5);
    assertEquals(5, stack.top());
  }

  @Test
  public void pushingASmallerItemEvictsNothing() {
    stack.push(5);
    stack.push(3);
    stack.pop();
    assertEquals(5, stack.top());
  }

  @Test
  public void pushingALargerItemEvictsTheTop() {
    stack.push(5);
    stack.push(8);
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushedItemIsOnTopAfterEvicting() {
    stack.push(5);
    stack.push(3);
    stack.push(8);
    assertEquals(8, stack.top());
  }

  @Test
  public void pushingALargerItemEvictsEverySmallerItem() {
    stack.push(5);
    stack.push(3);
    stack.push(8);
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushingAnEqualItemEvictsNothing() {
    stack.push(5);
    stack.push(5);
    stack.pop();
    assertEquals(5, stack.top());
  }

  @Test
  public void pushStopsEvictingAtAnItemThatIsNotSmaller() {
    stack.push(8);
    stack.push(6);
    stack.push(7);
    stack.pop();
    assertEquals(8, stack.top());
  }

  @Test
  public void manyDescendingPushesKeepTheMostRecentOnTop() {
    for (int i = 25; i >= 1; i--) {
      stack.push(i);
    }
    assertEquals(1, stack.top());
  }

  @Test
  public void manyDescendingPushesKeepTheFirstItemAtTheBottom() {
    for (int i = 25; i >= 1; i--) {
      stack.push(i);
    }
    for (int i = 1; i <= 24; i++) {
      stack.pop();
    }
    assertEquals(25, stack.top());
  }

  @Test
  public void pushNullThrows() {
    try {
      stack.push(null);
      fail("expected IllegalArgumentException when pushing null");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
