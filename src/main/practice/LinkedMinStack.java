package practice;

import java.util.NoSuchElementException;

/** A node-backed implementation of the MinStack ADT. */
public class LinkedMinStack implements MinStack {

  private Node head;  // the top of the stack, or null when empty

  private static class Node {
    Integer value;
    Node minPointer;  // the node holding the smallest value at or below this one
    Node next;

    Node(Integer value) {
      this.value = value;
    }
  }

  public LinkedMinStack() {
    head = null;
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
  public Integer getMin() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean isEmpty() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
