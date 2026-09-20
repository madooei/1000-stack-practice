package practice;

import java.util.NoSuchElementException;

/**
 * An array-backed monotonic stack of integers: the values decrease from bottom
 * to top, ties allowed.
 */
public class ArrayMonotonicStack {

  private Integer[] arr;  // the top is at index size - 1
  private int size;

  public ArrayMonotonicStack() {
    arr = new Integer[10];
    size = 0;
  }

  // Evicts every item strictly smaller than item, from the top down, then
  // places item on top. Throws IllegalArgumentException if item is null.
  public void push(Integer item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Removes the top item. Throws NoSuchElementException if the stack is empty.
  public void pop() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the top item without removing it.
  // Throws NoSuchElementException if the stack is empty.
  public Integer top() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  private void grow() {
    Integer[] bigger = new Integer[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
