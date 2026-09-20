# Stack — Practice: MinStack and MonotonicStack

Two practice problems that change the `Stack` contract. `MinStack` extends it with a `getMin` that runs in O(1). `ArrayMonotonicStack` changes `push` so it evicts smaller elements.

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
        Stack.java                 # the Stack ADT contract (copied from the chapter)
      practice/
        MinStack.java              # Stack<Integer> + getMin
        LinkedMinStack.java        # linked MinStack (per-node minPointer)
        ArrayMonotonicStack.java   # push evicts smaller elements
    test/
      practice/
        MinStackTest.java             # abstract: the getMin tests
        LinkedMinStackTest.java       # runs the suite against LinkedMinStack
        ArrayMonotonicStackTest.java  # tests for the evicting push
  scripts/
    test.sh                        # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.LinkedMinStackTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `stack.Stack<T>` — an unchanged copy of the chapter's `Stack` interface. `MinStack` extends it, so it is included here to keep this code self-contained.
- `practice.MinStack` — `Stack<Integer>` plus `getMin`, which returns the smallest value on the stack.
- `practice.LinkedMinStack` — a linked `MinStack` where each node keeps a `minPointer`, so `getMin` stays O(1) after a `pop`.
- `practice.ArrayMonotonicStack` — an array-backed stack whose `push` evicts every smaller element first, so the values decrease from bottom to top. It does not implement `Stack<Integer>`.
- `practice.MinStackTest` and `practice.LinkedMinStackTest` — the `getMin` suite and the class that runs it against `LinkedMinStack`.
- `practice.ArrayMonotonicStackTest` — tests for the evicting `push`.
