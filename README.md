# Clean code 

## Meaningful Names

* The name of a variable, must tell why it exists, what it does, and how it is used.
* The name of a variable, must not requrie a comment.
* The name of a variable, must be easily searchable.
* The length of a name should correspond to the size of its scope.
* Class names should be nouns, in mixed case with the first letter of each internal word capitalized.
* Methods should be verbs, in mixed case with the first letter lowercase, with the first letter of each internal word capitalized.

## Functions

* Don't repeat yourself. Check for duplicity.
* Must be as small, as possible.
* Must do only one thing.
* Every functions must be followed by those at the next level of abstaction.
* Functions with three or more arguments should be avoided.
* Prefer exceptions rather than returing error codes.
* Functions that handles errors should do nothing else. This implies that if the keyword
try exists in a function, it should be the very first word in the function and that there
should be nothing after the catch/finally blocks.
* A function should has only one return statement, no break or continue statements in a loop, and never, ever, any goto statements.
* Don't return and past null.

## Classes

* Must be as small, as possible.
* The name of a class should describe what responsibilities it fulfills.
* We should be able to write a brief description of the class in about 25 words, without using the words “if,” “and,” “or,” or “but.”
* A class or module should have one, and only one, reason to change. (Single Responsibility Principle)
* By default, Java classes should start with the variables:
  * Static and constantly public.
  * Static and variable private.
  * Instances and variables privates.
  * Soon after comes the functions.

## General

* Replace magical numbers with named constants. 
* Avoid negative conditionals.
* Keep configurable data at high levels.
* Use enums rather than constants.
* Remove code that is no longer in use.

## Tests

* At least 80% code coverage.
* Test everything that could break. Test corner cases.
* Don't skip trivial tests.
* Express yourself, as simple as poosible.

## SOLID Principles

### S - Single-responsiblity Principle

A class should have one and only one reason to change, meaning that a class should have only one job.

### O - Open-closed Principle

Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself.

### L - Liskov Substitution Principle

Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T. This means that every subclass or derived class should be substitutable for their base or parent class.

### I - Interface Segregation Principle

A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

### D - Dependency Inversion Principle

Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
