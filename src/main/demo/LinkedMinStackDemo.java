package demo;

import practice.LinkedMinStack;

/** A demo of LinkedMinStack on the sequence of operations from the notes. */
public final class LinkedMinStackDemo {

  private LinkedMinStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    LinkedMinStack stack = new LinkedMinStack();

    // Push 5, 2, 2, 7. Expect getMin to give 5, then 2, 2, 2.
    stack.push(5);
    System.out.println("push(5), getMin: " + stack.getMin());
    stack.push(2);
    System.out.println("push(2), getMin: " + stack.getMin());
    stack.push(2);
    System.out.println("push(2), getMin: " + stack.getMin());
    stack.push(7);
    System.out.println("push(7), getMin: " + stack.getMin());

    // Pop three times. Expect getMin to give 2, 2, and then 5
    // once the second 2 is gone.
    stack.pop();
    System.out.println("pop(), top: " + stack.top() + ", getMin: " + stack.getMin());
    stack.pop();
    System.out.println("pop(), top: " + stack.top() + ", getMin: " + stack.getMin());
    stack.pop();
    System.out.println("pop(), top: " + stack.top() + ", getMin: " + stack.getMin());
  }
}
