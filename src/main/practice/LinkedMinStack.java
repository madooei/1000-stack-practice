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
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node newNode = new Node(item);
    if (isEmpty() || item < head.minPointer.value) {
      newNode.minPointer = newNode;  // the new item is the new minimum
    } else {
      newNode.minPointer = head.minPointer;
    }
    newNode.next = head;
    head = newNode;
  }

  @Override
  public void pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    head = head.next;  // unlink the old top; its minPointer leaves with it
  }

  @Override
  public Integer top() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return head.value;
  }

  @Override
  public Integer getMin() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return head.minPointer.value;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }
}
