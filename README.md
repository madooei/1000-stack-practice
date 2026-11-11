# Stack — Practice

Four practice problems. Two use a stack to solve a problem: valid parentheses and evaluating Reverse Polish Notation. Two change the `Stack` contract: `MinStack` extends it with a `getMin` that runs in O(1), and `MonotonicStack` changes `push` so it evicts smaller elements.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      stack/
        Stack.java                       # the Stack ADT contract (copied from the chapter)
        ArrayStack.java                  # array-backed Stack (copied from the chapter)
        LinkedStack.java                 # node-backed Stack (copied from the chapter)
      practice/
        ValidParenthesesBruteForce.java  # remove adjacent pairs until none are left
        ValidParenthesesStack.java       # match brackets with a stack
        EvaluateRPNBruteForce.java       # reduce the first operator, again and again
        EvaluateRPNStack.java            # evaluate with a stack
        MinStack.java                    # Stack<Integer> + getMin
        LinkedMinStack.java              # linked MinStack (per-node minPointer)
        MonotonicStack.java              # push evicts smaller elements (not a Stack)
        ArrayMonotonicStack.java         # array-backed MonotonicStack
    test/
      practice/
        ValidParenthesesTest.java            # abstract: the valid-parentheses scenarios
        ValidParenthesesBruteForceTest.java  # runs them against ValidParenthesesBruteForce
        ValidParenthesesStackTest.java       # runs them against ValidParenthesesStack
        EvaluateRPNTest.java                 # abstract: the RPN scenarios
        EvaluateRPNBruteForceTest.java       # runs them against EvaluateRPNBruteForce
        EvaluateRPNStackTest.java            # runs them against EvaluateRPNStack
        MinStackTest.java             # abstract: the MinStack contract suite
        LinkedMinStackTest.java       # runs the suite against LinkedMinStack
        MonotonicStackTest.java       # abstract: the MonotonicStack contract suite
        ArrayMonotonicStackTest.java  # runs the suite against ArrayMonotonicStack
  scripts/
    test.sh                        # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ValidParenthesesBruteForceTest` — compiles everything and runs only that test class. Use this while you are working on one problem or one solution and the others are still empty. The class names are listed in the layout above.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `stack.Stack<T>` — an unchanged copy of the chapter's `Stack` interface. `MinStack` extends it, so it is included here to keep this code self-contained.
- `stack.ArrayStack<T>` and `stack.LinkedStack<T>` — complete copies of the chapter's two implementations. The stack solutions to valid parentheses and Reverse Polish Notation use them, not `java.util` collections.
- `practice.ValidParenthesesBruteForce` — `isValid`, which removes adjacent matched pairs until none are left.
- `practice.ValidParenthesesStack` — `isValid`, which pushes each opener and matches each closer against the top of a stack.
- `practice.EvaluateRPNBruteForce` — `evalRPN`, which reduces the first operator and its two operands to one number, again and again.
- `practice.EvaluateRPNStack` — `evalRPN`, which pushes each number and applies each operator to the top two numbers of a stack.
- `practice.ValidParenthesesTest` and `practice.EvaluateRPNTest` — the abstract scenario suites for the two problems. Each has one subclass per solution class, so you can test one solution alone.
- `practice.MinStack` — `Stack<Integer>` plus `getMin`, which returns the smallest value on the stack.
- `practice.LinkedMinStack` — a linked `MinStack` where each node keeps a `minPointer`, so `getMin` stays O(1) after a `pop`.
- `practice.MonotonicStack` — a stack of `Integer` whose `push` evicts every smaller element first, so the values decrease from bottom to top. It has the same four operations as `Stack` but does not extend it, because its `push` keeps a different promise.
- `practice.ArrayMonotonicStack` — an array-backed `MonotonicStack`.
- `practice.MinStackTest` and `practice.LinkedMinStackTest` — the `MinStack` contract suite and the class that runs it against `LinkedMinStack`.
- `practice.MonotonicStackTest` and `practice.ArrayMonotonicStackTest` — the `MonotonicStack` contract suite and the class that runs it against `ArrayMonotonicStack`.
