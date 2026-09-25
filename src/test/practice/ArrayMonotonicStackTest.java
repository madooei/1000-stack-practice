package practice;

/** Runs the MonotonicStack contract suite against ArrayMonotonicStack. */
public class ArrayMonotonicStackTest extends MonotonicStackTest {

  @Override
  protected MonotonicStack createMonotonicStack() {
    return new ArrayMonotonicStack();
  }
}
