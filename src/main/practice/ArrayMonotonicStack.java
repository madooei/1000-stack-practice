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
    if (item == null) {
      throw new IllegalArgumentException();
    }
    while (size > 0 && arr[size - 1] < item) {
      arr[size - 1] = null;  // evict the top, clearing the slot
      size--;
    }
    if (size == arr.length) {
      grow();
    }
    arr[size] = item;
    size++;
  }

  // Removes the top item. Throws NoSuchElementException if the stack is empty.
  public void pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    size--;
    arr[size] = null;  // clear the slot so the object can be garbage collected
  }

  // Returns the top item without removing it.
  // Throws NoSuchElementException if the stack is empty.
  public Integer top() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return arr[size - 1];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void grow() {
    Integer[] bigger = new Integer[arr.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = arr[i];
    }
    arr = bigger;
  }
}
