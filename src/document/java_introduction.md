# Java

1. Java is a **programming language** and a **platform**. 
2. Java is a **high level**, **robust**, **secured** and **object-oriented programming language**. 
3. **Platform**: Any hardware or software environment in which a program runs, is known as a platform. 
Since Java has its **own runtime environment (JRE)** and **API**, it is called platform

## Features of Java

![img](//document/images/java_feature.png)

### Simple
Java simplifies programming by removing confusing or rarely used features and includes **automatic garbage collection**.
### Object-oriented
Java follows the object-oriented programming paradigm, which organizes software into **objects** combining **data** and **behavior**.

![img](//document/images/oops.png)
### Platform Independent (WORA)
Java programs can run on any platform with a **Java Runtime Environment (JRE)**, thanks to **bytecode** compilation and the WORA principle.

![img](//document/images/platform_independent.png)
### Secured
Java provides security features such as **no explicit pointers**, **VM sandboxing**, **classloader**, **bytecode verifier**, and **security manager**.
* **Classloader**: Adds security by separating the package for the classes of the local file system from those that are imported from network sources.
* **Bytecode Verifier**: Checks the code fragments for **illegal code** that can **violate access right to objects**
* **Security Manager**: Determines what resources a class can access such as reading and writing to the local disk.
* Security can also be provided by application developer through SSL, JAAS, cryptography etc.

![img](//document/images/secured_java.png)
### Robust
Java ensures **strong memory management**, avoids security issues with pointers, features **automatic GC**, and includes robust **exception handling** and **type checking** at compile time.
### Architecture-neutral
Java's features are not dependent on any specific hardware or implementation.
### Portable
Java **bytecode** can be **executed** on any platform with a **compatible JRE**, making Java highly portable.
### High-performance
While **Java bytecode is faster than traditional interpretation**, it's somewhat slower than compiled languages like C++.
### Distributed
Java supports creating distributed applications with features like **Remote Method Invocation** (RMI) and **Enterprise JavaBeans** (EJB).
### Multi-threaded
Java allows for creating **multi-threaded** applications, enabling **concurrent execution** and **sharing of memory**, essential for tasks like multimedia and web applications.

## Understanding first java program

```java
public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World!!");
  }
}
```
* SAVE  HelloWorld.java
* To compile:	**javac** HelloWorld.java (file name)
* To execute:	**java** HelloWorld {class name including main()}

* **class** keyword is used to declare a class in java.
* **public** keyword is an **access modifier** which represents visibility, it means it is visible to all.
* **static** is a keyword, if we declare any method as static, it is known as static method. 
The core advantage of static method is that there is **no need to create object** to **invoke the static method**. 
> static `main()` is executed by the JVM, so it doesn't require to create object to invoke the main method. So it saves memory.
* **void** is the **return type** of the method, it means it doesn't return any value.(No need to return anything to JVM)
* **main** represents startup of the program.
* **String[] args** is used for command line argument.

### What happens at compile time?
At compile time, java file is compiled by Java Compiler and converts the java code into .class file i.e. **bytecode**.

### What happens at runtime?
At runtime, following steps are performed
* **Classloader**: is the subsystem of JVM that is used to load class files.
* **Bytecode Verifier**: checks the code fragments for illegal code that can violate access right to objects.
* **Interpreter**: read bytecode stream then execute the instructions.
  
![img](//document/images/runtime_java.png)
#### Can you save a java source file by other name than the class name?
    Yes, if the class is not public. 

>  Java will set a **default** access to a given class, method or property. 
<br>  The default access modifier is also called package-private, which means that all members are visible within the same package but aren't accessible from other packages


---
[Home](https://github.com/Piyushresonit/JavaCoreConcepts/blob/master/README.md)