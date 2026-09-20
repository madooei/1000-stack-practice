package practice;

/** Runs the MinStack contract suite against LinkedMinStack. */
public class LinkedMinStackTest extends MinStackTest {

  @Override
  protected MinStack createMinStack() {
    return new LinkedMinStack();
  }
}
