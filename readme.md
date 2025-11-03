# Dsa-work

A collection of Data Structures and Algorithms (DSA) implementations in Java, organized by topic for study and practice.

## Prerequisites
- Java JDK 11 or newer installed and available on PATH
- Optional: Visual Studio Code or another Java-capable editor

## Project structure (high level)

Core Algorithms
- Arrays
  - SegregateEvenAndOddNumbers.java
  - SortEvenOddUsingOneArray.java
- Searching
  - BinarySearch.java
  - SearchInArray.java
- Sorting
  - BubbleSort.java
  - CountSort.java
  - ExchangeSort.java
  - InsertionSort.java
  - MergeSort.java
  - QuickSort.java
  - RadixSort.java
  - SelectionSort.java

Data Structures
- Bits
  - CheckValueOfKthBit.java
  - ClearKbit.java
  - ToggleKthBit.java
  - setKbit.java
- Hashing
  - HashMapImplementation.java
  - HashSetImplemetation.java
- Linked List
  - CheckIfTheLinkedListIsAPalindrome.java
  - DeleteNode.java
  - FindingMiddleoOfTheLinkedList.java
  - Floyd’s Tortoise & Hare.java
  - LengthOfLinkedList.java
  - ReverseLinkedList.java
  - SearchingANode.java
- Questions
  - ArithmeticOperationsUsingStack.java
  - CheckIfArrayIsSorted.java
  - CountDigitOfANumber.java
  - DutchNationalFlag.java
  - MergeOneSortedArrayIntoAnother.java
  - MergingTwoLinkedListIntoOne.java
  - NumberToWords.java
  - PowerFunctionOptimesed.java
  - SumInAArray.java
  - SumInAArrayUsingStacks.java
  - SumInASortedArray.java
- Queues
  - CircularQueue.java
  - QueueUsingLinkedList.java
- Stacks
  - StacksWithLinkedList.java
  - stacksUsingArray.java

Recursion Practice
- ExponentialPowerNumbers.java
- FibonacciNumber.java
- Find the sum upto certain number.java
- FindFactorialOfGivenNumber.java
- PalindromeUsingRecursion.java
- PrintNumbersForwardAndBackward.java

Strings
- ReverseAString.java
- StringReplacement.java

## How to compile and run

From the project root (example uses zsh):

Compile a single file:
```bash
cd "/Users/vedant/Dsa-work/Data Structures/Questions"

java ArithmeticOperationsUsingStack
```

If a class is in the default package (no package declaration) you can run it by name as shown. If you add packages, compile with `javac -d .` and run with the fully qualified class name.

Tip for VS Code: open the folder, press `Ctrl+` ` (backtick) to open the integrated terminal, and use the same `javac`/`java` commands.

## Git / SSH usage

Use SSH for a smoother push/pull experience. Example flow:

1. Ensure your SSH key is added to the agent:
```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
```

2. Confirm connection to GitHub:
```bash
ssh -T git@github.com
```

3. Make and push changes:
```bash
git add .
git commit -m "Describe your changes"
git push
```

If push is rejected because the remote has new commits, fetch and rebase or pull and resolve conflicts first:
```bash
git fetch origin
git rebase origin/main
git push
```

If you prefer HTTPS, generate a Personal Access Token on GitHub and use it as the password when prompted.

## Contributing

- Keep code simple and well‑commented.
- Use descriptive names for variables and methods.
- Open a PR if you plan to add or refactor a larger section.

## Notes
- Many examples are single-file Java programs (default package) for learning. Converting to packages and adding a small build script (Maven/Gradle) is a good next step if you want to scale this project.

---

This repository is maintained for educational purposes.

