# Java_II_Project

This is the project for my CIS-175 Java II course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Introduction

In this week we just review what we learned in Java I.

**Object-Oriented Programming**

- *Class*: A blueprint that establishes the attributes and behaviors of a real-life object that we are trying to represent in code.
- *Instance/Reference Variables*: The private attributes of a class.
- *Methods*: The behaviors of a class. A Book class may have a variety of public methods to get and set values.
- *Constructor*: A special type of method used to instantiate objects using the class definition. A default constructor has no parameters and assigns default values to each of the instance variables. A standard constructor will typically accept one parameter for each instance variable and assign the parameter value to the instance variable.
- *Getter* (or *accessor*) methods will obtain current values from any of the instance variables. They will have a return type that matches the instance variable.
- *Setter* (or *mutator*) methods will change an instance variable value. They will always have a void return type. A single parameter must match the instance variable. 
- *Parameter(s)*: The input requirement(s) of a method.
- *Encapsulation*: Each object holds data unique to an individual instance. We gather, modify, and protect data through the use of setter (mutator) methods. We hide and restricting access to data through the use of with getter (accessor) methods.
- `toString()` method: A method that returns a String representation of an object of a particular type.
- *Overriding methods*: A child class rewrites code that was implemented in the parent class. In this example we are overriding the toString method.
- *Argument(s)*: The individual value(s) used when calling a method.
- *Static variable*: An instance variable that is shared by all objects that are instantiated from a class. 
- *Static method*: A type of method that can be called without instantiating an object from a class.
- *Interface*: a class that only has abstract methods (methods that must be declared in a class that implements the interface). Interfaces do not have instance variables unless they are declared public, static, and final. 
- *Abstraction*: The details of how an object works are hidden. In this example we are calling the static sort() method from the Arrays class.

## Test Driven Development (TDD)

**Test Driven Development**

Test-Driven Development (TDD) (or Unit Testing) is a technique for building software by writing test methods that verify that your code correctly outputs the expected results given a variety of inputs.

**Create Test Sources and Resources Root**

You will need to put test classes in a separate "tests" folder, not in your "src" folder. This helps on large code bases to keep the number of files you have to look through to a minimum. To do this we configure a Test Sources Root for the project. The Test Sources Root is a folder that stores your test source code.

**Assertion Methods**

There are some assertion method you need to know:

- `assertEquals(expected, actual)`: 	Test that two values are equal.
- `assertEquals(expected, actual, delta)` - for double:  Test that two doubles are equal to within a positive delta.
- `assertNotEquals(expected, actual)`:     Test that two values are not equal.
- `assertTrue(condition)`:      Test that a condition is true.
- `assertFalse(condition)`:     Test that a condition is false.
- `assertNotNull(object)`:      Test that an object isn't null.
- `assertNull(object)`:         Test that an object is null.  
- `assertThrows(expectedType, executable)`:   Test that execution of a supplied statement throws an exception.
- `assertAll(executables)`:     Asserts that all supplied statements do not throw exceptions. 

**BeforeEach Methods**

Tests often require a default instance of the class. The setUp method can be used to instantiate that object needed for each test. Example:

```java
private Person person;

@BeforeEach
void setUp() {
    person = new Person();
}
```

**Implement Comparable**

You need to do this to make the class comparable:
```java
public class Person implements Comparable<Person> {

//...

@Override
public int compareTo(Person o) {
    return 0;
}
```
