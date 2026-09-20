package practice;

import java.util.NoSuchElementException;
import stack.Stack;

/** A MinStack is a Stack of Integers that also reports its smallest item. */
public interface MinStack extends Stack<Integer> {

  /**
   * Returns the smallest item on this stack without removing it.
   *
   * @return the smallest item on this stack.
   * @throws NoSuchElementException if this stack is empty.
   */
  Integer getMin();
}
