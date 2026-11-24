package demo;

import practice.ArrayMonotonicStack;

/** A demo of ArrayMonotonicStack on the sequence of pushes from the notes. */
public final class ArrayMonotonicStackDemo {

  private ArrayMonotonicStackDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    ArrayMonotonicStack stack = new ArrayMonotonicStack();

    // Push 5, 3, 8, 6, 7. Each push evicts every smaller element first.
    // Expect the top to be 5, 3, 8, 6, 7 after each push.
    int[] items = {5, 3, 8, 6, 7};
    for (int item : items) {
      stack.push(item);
      System.out.println("push(" + item + "), top: " + stack.top());
    }

    // Only 7 and 8 are left. Expect them top first: 7, then 8.
    while (!stack.isEmpty()) {
      System.out.println("pop " + stack.top());
      stack.pop();
    }
  }
}
