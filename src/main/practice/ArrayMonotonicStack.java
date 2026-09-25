package practice;

import java.util.NoSuchElementException;

/** An array-backed MonotonicStack. */
public class ArrayMonotonicStack implements MonotonicStack {

  private Integer[] arr;  // the top is at index size - 1
  private int size;

  public ArrayMonotonicStack() {
    arr = new Integer[10];
    size = 0;
  }

  @Override
  public void push(Integer item) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void pop() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public Integer top() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
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
