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

## Collections

**Containers and collections**

Containers or collections are classes that let you store and process several objects at once. 
Java has several dozen collections, each of which stores elements in its own specific way. Here are a few of them:
- `List<E>`
- `Set<E>`
- `Queue<E>`
- `Map<K,V>`

**HashSet collection**

The HashSet class is similar to the ArrayList class, except that in only allows unique elements.
You can create a HashSet object using a statement like:
```java
Set<Type> name = new HashSet<Type>();
```

Where Type is the type of the elements we will store in the HashSet collection.
There are only three things you can do with a set: 
add elements to the set, remove elements from the set, 
and check whether the set contains a specific element. That's it.

**Iterator for a collection**

Iterators were proposed as a solution to the problem above.
An Iterator is a special object associated with a collection, 
which helps traverse all the elements of the collection without repeating any.
You can use the following code to get an iterator for any collection, 
where name is the name of collection variable, Type is the type of the elements of the collection, 
iterator() is one of the collection's methods, and it is the name of the iterator variable.
```java
Iterator<Type> it = name.iterator();
```

**HashMap class**

The HashMap class is the most popular kind of Map collection. 
On the one hand, it is very similar to HashSet and has all its methods. 
On the other hand, it is like a list (ArrayList) that can use words (or anything else) as its indices.

You can create a HashMap using a statement like this, where KeyType is the type of the keys in the stored pairs, and ValueType is the type of the values in the pairs stored in the HashMap collection.
```java
HashMap<KeyType, ValueType> name = new HashMap<KeyType, ValueType>();
```

The HashMap class has methods like this:
```java
void put(KeyType key, ValueType value)	//Adds the (key, value) pair to the collection
ValueType get(KeyType key)	//Returns the value associated with a key.
boolean containsKey(KeyType key)	//Checks whether a key exists in the collection
boolean containsValue(ValueType value)	//Checks for the existence of a value in the collection
ValueType remove(KeyType key)	//Removes an element from the collection
void clear()	//Clears the collection, removing all the elements
int size()	//Returns the number of key-value pairs in the collection
Set<KeyType> keySet()	//Returns the set of keys in the collection
Collection<ValueType> values()	//Returns a set containing the elements of the collection
Set<Map.Entry<KeyType, ValueType>> entrySet()	//Returns a set (Set) of all pairs (Map.Entry) in the collection.
```

**Looping over key-value pairs**

Two ways to loop through a map is:

```java
for(Map.Entry<String, Integer> pair: map.entrySet()) {
   String key = pair.getKey();
   Integer value = pair.getValue();
   System.out.println(key + " --> " + value);
}
```
Or:
```java
for(var pair: map.entrySet()) {
   String key = pair.getKey();
   Integer value = pair.getValue();
   System.out.println(key + " --> " + value);
}
```

**Printing Collection Objects**

*Consumer* is a functional interface with a single abstract method called accept(), 
which takes in a value of type T and returns void.

- forEach Method:
```java
collection.forEach(System.out::println);
```
- Avoiding Loops:
```java
System.out.println(Arrays.toString(collection.toArray()));
//Or:
System.out.println(collection.stream().map(Object::toString).collect(Collectors.joining(", ")); //doesn't include the brackets
```

**Deep vs Shallow Copy**

- Shallow Copy: This code makes a shallow copy of an ArrayList. 
This means that when you call a mutator method on an object, 
it will change the copy as well as the original copy it references. 
You can also use the ArrayList's clone() method to create a shallow copy.
```java
List<Employee> employeesCopy = new ArrayList<>(employees);
printCollection(employeesCopy);
```
- Deep Copy: When you make a change to the copy it will not change the original one.
To do it you need to start by specifying that the class implements the Cloneable interface.
```java
public class Employee extends Person implements Comparable<Employee>, Cloneable
```
Then add a clone() method to the Person class like the one shown below:
```java
@Override
protected Employee clone() {
    try{
        return (Employee) super.clone();
    } catch(CloneNotSupportedException e){
        throw new RuntimeException(e);
    }
}
```
Instantiate the copy ArrayList so that it is the same size as the original.
```java
List<Employee> employeesCopy = new ArrayList<>(employees.size());
```
Then call the iterator() method from the original ArrayList to obtain a Iterator object.
```java
Iterator<Employee> iterator = employees.iterator();
```
Call the iterator object's `hasNext()` method to run a while loop through each 
the elements in the original list. Add each element one at a time to the new copy list.
```java
while(iterator.hasNext()){
employeesCopy.add(iterator.next().clone());
}
printCollection(copy);
```

## Contributing to Open Source Projects

In this chapter we practiced contributing to open source projects by participating in Hacktoberfest.

**Vocabulary**
- *Open source*: You can contribute to other developer's projects to make better, more reliable software.
- *Maintainer*: A person that maintains an open source project.
- *Contributor*: A person that contributes to another developer's open source project.
- *Fork*: Make a copy of another developer's repository.
- *Clone*: Make a local copy of a project to your local machine.
- *Origin*: The name of the remote alias from your local machine to your forked copy of the project.
- *Upstream*: The name of the remote alias of the original project.
- *Version control*: Software that allows developers to save and track changes made to a project.
- *Git*: A version control system used to manage developer projects.
- *GitHub*: A cloud-based repository hosting service that allows developers to share code.
- *Repository*: You can use repositories to store a variety of projects on GitHub repositories. You can use repositories to collaborate with others and track your work.
- *Issue*: A section of a GitHub repository where you can keep track of tasks, enhancements, and bugs for your project that need to be corrected.
- *Branch*: A parallel version of a repository. It is contained within the repository, but does not affect the primary or main branch allowing you to work freely without disrupting the "live" version.
- *Pull request*: Pull requests give developers the ability to work together as a team and discuss changes. A contributor requests a change, adds a comment, and the owner can approve or deny the request.
- *Merge conflict*: Something that happens when two developers make changes to the same file on GitHub.

*Fork* creates a copy of the original repository on our GitHub account. 
*Clone* creates a copy of the original repository on our local computer.

## Generics

**Generics Summary**
- Provide flexible type safety to your code
- Move many common errors from run time to compile time
- Provide cleaner, easier-to-write code
- Are reusable and reliable
- Reduce the need for casting with collections
- Are used heavily in the Java Collections API

**Generics**

A Generic is a data type that can be passed to classes, interfaces, and methods. 
In Java, this is done with diamond notation <>.

`<T>` is a generic. 
Between the two brackets we can declare one or more Type parameters. 
Example: `<T, X, Y, Z>`. We can name our parameters whatever we want. 
`<T>` is just what's typically used.
It's exactly like how a method has parameters. 
However, instead of passing in values, 
we passing in data types

Note that the `<>` brackets are required after both the data type and the constructor name. 
You are required to declare the type argument for the data type. 
You are allowed to omit the type argument on the constructor.
Type erasure happens at compile time when using generics.

**Type Parameters to Methods**

In addition to classes, we can also add type parameters to methods. 
The code below calls an add method inside the main method. 
It takes in a fruit object, and a box object, 
and prints out what type of item it is before adding items to a box.
```java
public static <T> void add(T item, Box<T> box) {
        box.add(item);
}
```

**Extending Type Parameters**

One last thing to note about Type parameters is that by default, our T parameter extends the Object class.
```java 
class Box<T extends Object>
```
If you want to further limit the allowed type parameters, you can require it to extend of a certain object.
```java 
class Box<T extends Fruit>
```
Then we would need to alter the add method to include the updated type method.
```java 
public static <T extends Fruit> void add(T item, Box<T> box)
```

**Using Wildcard Arguments**

The wildcard argument <?> represents an unknown type. 
Here, NumericFns<?> matches any valid type of NumericFns object.
```java
NumericFns<?> ob
```

## Lambda Expressions

**Functional Interfaces**

A functional interface is an interface with exactly one abstract method. The abstract method typically specifies the intended purpose, or single action, of the interface.

**Lambda Expressions**

The name "Lambda Expression" comes from a technique for defining mathematical functions in Lambda calculus.  The primary variable in these functions was the Greek letter lambda: λ.

Lambda expression do the same things as other methods, but are a way of making a quick use method definition. 
Lambda expressions cannot be executed on their own. 
Instead, they are used to implement a method defined by a functional interface. 
They provide a more declarative style of coding known as functional programming.

Lambda Expressions start with an argument list, is followed by the arrow token, and then in the body, you provide the statement that you want to return. 
The data types of the arguments and the return type are inferred from the interface that it comes from. 
A lambda expression can be assigned only to a functional interface reference. 
```java
MyAnalyzer<String> contains = (search, target) -> target.contains(search);
```

**Supplier Interface**

The Supplier functional interface is a generic interface that has one abstract method called 
`get()` that takes no arguments and returns an item of type T. 

Example:
```java
Supplier<Integer> diceRoll = () -> ThreadLocalRandom.current().nextInt(1, 7);
for(int i = 0; i < 20; i++) {
  System.out.print(diceRoll.get() + " ");
}
```

**Consumer Interface**

The Consumer functional interface is a generic interface that has 
one abstract method called `accept()` that takes one argument of type T and returns void.

```java
Consumer<String> yellIt = str -> System.out.println(str.toUpperCase() + "!!!");
yellIt.accept("give me pizza"); // GIVE ME PIZZA!
```

**BiConsumer Interface**

The BiConsumer functional interface is a generic interface that has one abstract method called `accept()` that takes two arguments of type T and U and returns void. 

```java
BiConsumer<Integer, Integer> sum = (x, y) -> System.out.println(x + y);
sum.accept(2, 3); // 5
```

**Predicate Interface**

The Predicate functional interface is a generic interface that has one abstract method called `test()` 
that takes one argument of type T and returns a boolean. 
These can be used in if statements, while loops, an ternary operators.

```java
Predicate<Integer> isEven = num -> num % 2 == 0;
System.out.println("4" + " is " + (isEven.test(4) ?  "even" : "odd"));
```

**BiPredicate Interface**

The BiPredicate functional interface is a generic interface that has one abstract method called `accept()` that takes two arguments of type T and returns void. 

```java
BiPredicate<String, String> lengthMatches = (s1, s2) -> s1.length() == s2.length();
System.out.println(lengthMatches.test("Java", "Cool"));
```

**Method References**

Method reference: A lambda expression mechanism for referring to a method name without executing the method.
The notation is typically the name of a class (for static methods) or the name of an object (for instance methods), then two colons ::, and then the name of the method without parentheses.
`ClassName::methodName`
```java
Supplier<Book> createNewBook = Book::new; // This one use constructor reference
Book book = createNewBook.get();

Predicate<String> match = String::isBlank; // This one use static methods
```

**Function Interface**

The Function functional interface is a generic interface that has one abstract method called `apply()` 
that takes one argument of type T and returns a value of type R. 
T and R can be the same type of object or different objects.
```java
Function<Integer, Boolean> isEven = num -> num % 2 == 0;
System.out.println("4 is a" + (isEven.apply(4) ? " even" : " odd") + " number");
```

BiFunction Interface are the same with Function Interface, but it can take two arguments of type T and U, and returns a value of type R.

**UnaryOperator Interface**

The UnaryOperator functional interface is a generic interface that extends the Function Interface as previously discussed. 
Therefore we can use the `apply()` abstract method. 
The difference is that we specify a single object type T which will be used for both the input and the output.
```java
UnaryOperator<LocalDate> finalGradesDueBy = date -> date.plusDays(3);
LocalDate lastDayOfFinals = LocalDate.parse("2022-12-13");
System.out.println("My grades are due by " + finalGradesDueBy.apply(lastDayOfFinals));
```

The BinaryOperator functional interface is a generic interface that extends the BiFunction Interface as previously discussed. Therefore we can use the `apply()` abstract method. 
The difference is that we specify a single object type T which will be used for two inputs and the output.

```java
BinaryOperator<Integer> max = (a, b) -> (a >= b) ? a : b;
System.out.println(max.apply(2, 3));
```

## GENERAL ETHICAL PRINCIPLES

### 1.1 Contribute to society and to human well-being

I promise that the things I do as well as the things I create are meant to benefit the community and society. 
As well as will not create anything that threatens health, safety, personal security and privacy.

### 1.2 Avoid harm

I promise that I will not create anything that can harm others. 
As well as will try to minimize the possibility of indirect or unintentional harm to others.

### 1.3 Be honest and trustworthy.

I promise will always be honest in all circumstances. Nor will making false or misleading statements, 
fabricating or falsifying data, giving or accepting bribes and other dishonest practices is a violation of the Code.

### 1.4 Be fair and take action not to discriminate.

I promise will always be fair and equal to all. Regardless of nationality, race, religion or creed, gender.

### 1.5 Respect the work required to produce new ideas, inventions, creative works, and computing artifacts.

I promise that I will respect the invention and creative rights of others. As well as will never steal other peoples creations.

### 1.6 Respect privacy.

I promise that I will respect the privacy of others' information. 
I promise to only use personal information for lawful purposes and not to violate the rights of individuals and groups.

### 1.7 Honor confidentiality.

I promise will always keep customer information and data confidential. As well as will never use them for any unauthorized activities.

The Iterable interface defines a forEach method. The required parameter is a(n):
Consumer object

Which of the following does not inherit from the Collection interface?
Map

Which of the following is true about Map data structures?
Keys must be unique, values may be duplicates

What is a correct way to create an instance of an ArrayList?
List<String> cart = new ArrayList<>();

What must replace the ???'s in order for the ArrayList to support the sort() method?
Any class that implements the Comparable interface

Which of the following uses First-In, First-Out (FIFO) data storage?
Queue

Select the code sample that will NOT print all elements in the groceryList.
for(int i = 0; i < groceryList.size(); i++) {
System.out.println(groceryList.get(i) + "=" + i);
}

The __ interface requires you to override the compare method and enables you to create numerous sorting options.
Comparator

Which of the following prohibits duplicate entries?
Set

Assume objects alpha and beta are both instances of class Example, which implements Comparable.  If alpha should appear after beta in a sorted list, what is returned by alpha.compareTo(beta)?
A positive integer

What is a correct way to create an instance of a HashMap?
Map<String, Integer> cart = new HashMap<>();

To make a copy of an ArrayList that is not a reference to the original, you need to specify that the class implements the __ interface.
Cloneable
Branch Test Notes
To make a new branch, the git term is called _.
Checkout

A(n) __ is a separate parallel version of the main repository.
(branch)

What is the name of the remote alias of the original project?
Upstream

To get the lastest changes from your remote repository, the git command is?
Pull

What is the command to make your fork's main branch be in sync with the upstream repository.
Merge

When creating a public repository for an open source project, make sure to include a __ file, which may tell contributors that the maintainer assumes no liability.
LICENSE

How do you submit code to be reviewed for an open source project?
By creating a pull request through the GitHub interface

A(n) __ may occur when two developers make changes to the same file on GitHub.
merge conflict

What is the command to get all the change history from the remote repository without applying changes to your code.
Fetch

How do you create a copy of someone else's GitHub repository under your own GitHub account?
By forking it via the GitHub interface.

Generics
Declare a class called MyGen that has two generic type parameters, called T and V. Change the second type parameter so that it must extend Number:
MyGen<T, V extends Number>

Declare a class called MyGen that takes has two generic type parameters, called T and V:
Answer:    MyGen<T, V>

class MyClass<T, U> {
public MyClass(T t, U u) {
System.out.println(t + " " + u);
}
}
MyClass<> obj = new MyClass<Double, String>(1.1, "Hi");

Look up the documentation for the assertThrows method in the JUnit Assertions API.
What does <T extends Throwable> mean?
public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable)

The expectedType must be a class that is a subclass of the Throwable class.

Declare a class called MyGen that takes has a single generic type parameter, called T:
Answer:    MyGen<T>

Which statement is false about <?>?
? must be followed with extends or super

Which of the following cannot be used as a type argument?
double

Declare a method called mystery that has one type parameter, T. This method has one parameter whose type is that of the type parameter. It returns an object of that type parameter.
(<T> T mystery(T o))

Type parameters are _ during compilation, and appropriate casts are substituted during run time.
erased

Which statement is FALSE concerning generics?
Common errors with generics occur during run time.
