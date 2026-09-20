package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests for ArrayMonotonicStack. Most of them are about the evicting push. */
public class ArrayMonotonicStackTest {

  private ArrayMonotonicStack stack;

  @BeforeEach
  public void setup() {
    stack = new ArrayMonotonicStack();
  }

  @Test
  public void pushOntoEmptyStackEvictsNothing() {
    stack.push(5);
    assertEquals(5, stack.top());
    assertFalse(stack.isEmpty());
  }

  @Test
  public void onePushEvictsSeveralSmallerElements() {
    stack.push(5);
    stack.push(3);
    stack.push(8);   // evicts both 3 and 5
    assertEquals(8, stack.top());
    stack.pop();
    assertTrue(stack.isEmpty());   // only 8 remained
  }

  @Test
  public void pushEqualToTopEvictsNothing() {
    stack.push(5);
    stack.push(5);   // tie: only strictly smaller elements are evicted
    assertEquals(5, stack.top());
    stack.pop();
    assertEquals(5, stack.top());   // the first 5 survived
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushCanDrainTheWholeStackBeforePlacing() {
    stack.push(6);
    stack.push(2);
    stack.push(9);   // 9 is larger than everything: the stack empties first
    assertEquals(9, stack.top());
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void stackStaysNonIncreasingFromBottomToTop() {
    stack.push(4);
    stack.push(9);   // evicts 4
    stack.push(1);
    stack.push(6);   // evicts 1
    stack.push(6);   // tie survives
    stack.push(2);
    assertEquals(2, stack.top());   // top first: 2, 6, 6, 9
    stack.pop();
    assertEquals(6, stack.top());
    stack.pop();
    assertEquals(6, stack.top());
    stack.pop();
    assertEquals(9, stack.top());
    stack.pop();
    assertTrue(stack.isEmpty());
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
  public void topOnEmptyStackThrows() {
    try {
      stack.top();
      fail("expected NoSuchElementException when calling top on an empty stack");
    } catch (NoSuchElementException e) {
      return;
    }
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

  @Test
  public void manyDescendingPushesGrowPastTheInitialCapacity() {
    for (int i = 25; i >= 1; i--) {
      stack.push(i);   // descending, so nothing is ever evicted
    }
    for (int i = 1; i <= 25; i++) {
      assertEquals(i, stack.top());
      stack.pop();
    }
    assertTrue(stack.isEmpty());
  }
}
