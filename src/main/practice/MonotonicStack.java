package practice;

import java.util.NoSuchElementException;

/**
 * A MonotonicStack is a stack of Integers whose values decrease from bottom to
 * top, ties allowed. It has the same four operations as Stack, but push keeps
 * a different promise: it evicts every item smaller than the new item before
 * placing it on top. A MonotonicStack is therefore not a Stack.
 */
public interface MonotonicStack {

  /**
   * Evicts every item strictly smaller than the given item, from the top down,
   * then places the item on top of this stack.
   *
   * @param item the item to be pushed onto this stack.
   * @throws IllegalArgumentException if the item is null.
   */
  void push(Integer item);

  /**
   * Removes the item at the top of this stack.
   *
   * @throws NoSuchElementException if this stack is empty.
   */
  void pop();

  /**
   * Returns the item at the top of this stack without removing it.
   *
   * @return the item at the top of this stack.
   * @throws NoSuchElementException if this stack is empty.
   */
  Integer top();

  /**
   * Returns true if this stack contains no elements.
   *
   * @return true if this stack is empty, false otherwise.
   */
  boolean isEmpty();
}
