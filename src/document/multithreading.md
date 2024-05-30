# Multithreading in Java

1. Allows **concurrent execution** of two or more threads of a program for **maximize utilization of CPU**. 
2. A thread is a **lightweight sub process**, a smallest unit of processing. It is a separate path of execution. 
3. Threads are **independent**: Exception in one thread doesn't affect other threads.
4. you can perform multiple operations at same time which saves time.
5. It **shares a common memory area**.


Thread is executed inside the process. There is context-switching between the threads. 
There can be multiple processes inside the OS and one process can have multiple threads.
> At a time, one thread is executed only.

![img](/images/thread.png)

## Life cycle of a Thread (Thread States)

* A thread can be in one of the five states in thread life cycle in java **new**, **runnable**, **non-runnable**, **terminated** and **running** state. 
* The life cycle of the thread in java is **controlled by JVM**

![img](/images/threadlifecycle.png)
* **New**: The thread is in new state if you create an instance of Thread class but before the invocation of `start()` method.
* **Runnable**: The thread is in runnable state after invocation of `start()` method, but the **thread scheduler** has not selected it to be the running thread.
* **Running**: The thread is in running state if the thread scheduler has **selected thread**.
* **Non-Runnable (Blocked)**: This is the state when the thread is still **alive**, but is currently **not eligible to run**.
* **Terminated**: A thread is in **terminated** or **dead** state when its `run()` method exits.

## Create New Thread

1. By implementing Runnable interface
2. By extending Thread class

### By implementing Runnable interface

* The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
* Runnable interface have only one method named run().

`public void run()` is used to perform action for a thread.

```java
public class MyThreadImplRunnable implements Runnable{
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread test = new Thread(new MyThreadImplRunnable());
            test.start();
        }
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running");
    }
}
```
#### Output:
    Thread 24 is running 
    Thread 26 is running
    Thread 25 is running

### By extending Thread class

> Thread class extends Object class and implements Runnable interface.

#### Commonly used Constructors of Thread class:
Thread()
<br>Thread(String name)
<br>Thread(Runnable r)
<br>Thread(Runnable r, String name)

#### Commonly used methods of Thread class:

| [**Method**]()                       | [**Description**]()                                                                                                    |
|--------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| public void run()                    | Used to perform action for a thread.                                                                                   |
| public void start()                  | Starts the execution of the thread. JVM calls the run() method on the thread.                                          |
| public void sleep(long miliseconds)  | Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds. |
| public void join()                   | Waits for a thread to die.                                                                                             |
| public void join(long miliseconds)   | Waits for a thread to die for the specified milliseconds.                                                              |
| public int getPriority()             | Returns the priority of the thread.                                                                                    |
| public int setPriority(int priority) | Changes the priority of the thread.                                                                                    |
| public String getName()              | Returns the name of the thread.                                                                                        |
| public void setName(String name)     | Changes the name of the thread.                                                                                        |
| public Thread currentThread()        | Returns the reference of currently executing thread.                                                                   |
| public int getId()                   | Returns the id of the thread.                                                                                          |
| public Thread.State getState()       | Returns the state of the thread.                                                                                       |
| public boolean isAlive()             | Tests if the thread is alive.                                                                                          |
| public void yield()                  | Causes the currently executing thread object to temporarily pause and allow other threads to execute.                  |
| public boolean isDaemon()            | Tests if the thread is a daemon thread.                                                                                |
| public void setDaemon(boolean b)     | Marks the thread as daemon or user thread.                                                                             |
| public void interrupt()              | Interrupts the thread.                                                                                                 |
| public boolean isInterrupted()       | Tests if the thread has been interrupted.                                                                              |
| public static boolean interrupted()  | Tests if the current thread has been interrupted.                                                                      |

### Starting a thread

`start()` method of Thread class is used to start a newly created thread.
The thread moves from New state to the Runnable state.
When the thread gets a chance to execute, its target `run()` method will run.

```java
public class MyThread extends Thread {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + currentThread().getId() + " is running ");
    }
}
```
#### Output:
    Thread 27 is running 
    Thread 29 is running
    Thread 25 is running

### Can we start a thread twice? `No` `IllegalThreadStateException` 
After starting a thread, it can never be started again. 
If you does so, an `IllegalThreadStateException` is thrown. 
In such case, thread will run once but for second time, it will throw exception.

```java
public static void main(String args[]) {
    TestThreadTwice t1 = new TestThreadTwice();
    t1.start();
    t1.start(); // IllegalThreadStateException
}

public void run() {
        System.out.println("running...");
} 
```
#### Output:
    running...
    Exception in thread "main" java.lang.IllegalThreadStateException
    at java.base/java.lang.Thread.start(Thread.java:793)
    at com.resonit.multithreading.TestThreadTwice.main(TestThreadTwice.java:7)

### What if we call run() method directly instead start() method? `Uses Old Call Stack`
* Each thread starts in a separate call stack.
* Invoking the `run()` method from main thread, the `run()` method goes onto the **current call stack** rather than at the beginning of a new call stack.
* There is **No context-switching** because here object will be treated as **normal object not thread object**.

![img](/images/runcallstack.png)

```java
public static void main(String[] args) {
    TestCallRun t1 = new TestCallRun();
    t1.run();   //fine, but does not start a separate call stack
}

public void run() {
        System.out.println("running...");
} 
```
#### Output:
    running...
#### No Context Switching
```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfThreads = sc.nextInt();

    for (int i = 0; i < numOfThreads; i++) {
        Thread thread = new Thread(new TestCallRunContextSwitch());
        thread.run();
    } 
}

@Override
public void run() {
    System.out.println("Thread " + currentThread().getId() + " is running ");
}
```
#### Output:
    3
    Thread 1 is running
    Thread 1 is running
    Thread 1 is running

### Thread Scheduler in Java
>**Thread scheduler** in java is the part of the **JVM** that **decides which thread should run**.

* There is **No guarantee** that which runnable thread will be chosen to run by the thread scheduler.
* Only one thread at a time can run in a single process.
* The thread scheduler mainly uses preemptive or time slicing scheduling to schedule the threads.
  * **Preemptive scheduling**: The highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence. 
  * **Time slicing scheduling**: A task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on priority and other factors.

```java
class NewThread implements Runnable {
  public NewThread() {
    Thread t = new Thread(this, "DemoThread");
    System.out.println("Child thread: " + t);
    t.start(); // Start the thread
  }

  public void run() {
    try {
      for (int i = 3; i > 0; i--) {
        System.out.println("Child Thread: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("Child interrupted.");
    }
    System.out.println("Exiting child thread.");
  }
}

class ThreadDemo {
  public static void main(String args[]) {
    new NewThread(); // create a new thread
    try {
      for (int i = 3; i > 0; i--) {
        System.out.println("Main Thread: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }
    System.out.println("Main thread exiting.");
  }
}
```
#### Output:
    Child thread: Thread[DemoThread,5,main]
    Main Thread: 3
    Child Thread: 3
    Child Thread: 2
    Main Thread: 2
    Child Thread: 1
    Exiting child thread.
    Main Thread: 1
    Main thread exiting.

#### `sleep()` in java
The `sleep()` is used to sleep a thread for the specified amount of time.

    public static void sleep(long miliseconds)throws InterruptedException
    public static void sleep(long miliseconds, int nanos)throws InterruptedException

#### `join()` in java

The `join()` waits for a thread to die. 
It causes the currently running threads to stop executing until the thread it joins with completes its task.

    public void join()throws InterruptedException
    public void join(long milliseconds)throws InterruptedException

#### `currentThread()` in java

`currentThread()` returns a reference to the currently executing thread object.

```java
class TestSleepMethod extends Thread {
  public static void main(String args[]) {
    TestSleepMethod t1 = new TestSleepMethod();
    TestSleepMethod t2 = new TestSleepMethod();
    TestSleepMethod t3 = new TestSleepMethod();

    try {
      t1.setName("ThreadObject1");
      t2.setName("ThreadObject2");
      t3.setName("ThreadObject3");
      t1.start();
      t1.join();  // this will ensure t1 execute completely then it will execute next statements in main
      t2.start();
      t3.start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    for (int i = 1; i < 5; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      System.out.println("Thread " + Thread.currentThread().getId() + " is running");
      System.out.println("Thread " + Thread.currentThread().getName() + " is running");
    }
  }
}
```
#### Output:
    Thread 24 is running
    Thread ThreadObject1 is running
    Thread 24 is running
    Thread ThreadObject1 is running
    Thread 24 is running
    Thread ThreadObject1 is running
    Thread 25 is running
    Thread ThreadObject2 is running
    Thread 26 is running
    Thread ThreadObject3 is running
    Thread 25 is running
    Thread ThreadObject2 is running
    Thread 26 is running
    Thread ThreadObject3 is running
    Thread 25 is running
    Thread 26 is running
    Thread ThreadObject3 is running
    Thread ThreadObject2 is running

### Priority of a Thread (Thread Priority)

* Each thread have a priority. 
* Priorities are represented by a number between 1 and 10. 
* In most cases, **thread scheduler** schedules the threads according to their priority (known as preemptive scheduling).
* But it is not guaranteed because it depends on JVM specification that which scheduling it chooses.
* **Default priority** of a thread is **5** (**NORM_PRIORITY**). The value of MIN_PRIORITY is 1 and the value of MAX_PRIORITY is 10
* 3 constants defined in Thread class:
  * public static int MIN_PRIORITY - 1
  * public static int NORM_PRIORITY - 5
  * public static int MAX_PRIORITY - 10

`setPriority()` Changes the priority of the thread.
```java
public class ThreadPriority extends Thread {
  public static void main(String args[]) {
    ThreadPriority t1 = new ThreadPriority();
    ThreadPriority t2 = new ThreadPriority();

    try {
      t1.setName("ThreadObject1");
      t2.setName("ThreadObject2");
      t1.setPriority(MAX_PRIORITY);
      t2.setPriority(MIN_PRIORITY);
      t1.start();
      t2.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      System.out.println("Thread " + Thread.currentThread().getName() + " is running");
      System.out.println("Thread " + Thread.currentThread().getName() + " priority is " + Thread.currentThread().getPriority());
    }
  }
}
```
#### Output:
    Thread ThreadObject2 is running
    Thread ThreadObject1 is running
    Thread ThreadObject1 priority is 10
    Thread ThreadObject2 priority is 1
    Thread ThreadObject1 is running
    Thread ThreadObject2 is running
    Thread ThreadObject1 priority is 10
    Thread ThreadObject2 priority is 1

### Daemon Thread in Java

* Daemon thread in java is a **service provider thread** that provides services to the user thread. 
* It is a **low priority thread**
* Its life depend on the mercy of user threads i.e. when all the user threads dies, JVM terminates this thread automatically.
* There are much java daemon threads running automatically e.g. gc, finalizer etc.
* You can see all the detail by typing the `jconsole` in the command prompt. 
* The `jconsole` tool provides information about the **loaded classes**, **memory usage**, **running threads** etc.

#### Why JVM terminates the daemon thread if there is no user thread? 
The sole purpose of the daemon thread is that it provides services to user thread for background supporting task. If there is no user thread, why should JVM keep running this thread? That is why JVM terminates the daemon thread if there is no user thread.

`public void setDaemon(boolean status)` is used to mark the current thread as daemon thread or user thread.
`public boolean isDaemon()` is used to check that current thread is daemon.

```java
public class TestDaemonThread extends Thread {
    public static void main(String[] args) {
        TestDaemonThread t1 = new TestDaemonThread();//creating thread
        TestDaemonThread t2 = new TestDaemonThread();
        TestDaemonThread t3 = new TestDaemonThread();

        t1.setDaemon(true);//now t1 is daemon thread
        t1.start();//starting threads
        t2.start();
        t3.start();
    }

    public void run() {
        if (Thread.currentThread().isDaemon()) {//checking for daemon thread
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }
}
```
#### Output:
    daemon thread work
    user thread work
    user thread work

> If you want to make a user thread as Daemon, it must not be started otherwise it will throw `IllegalThreadStateException`.
```java
public static void main(String[] args){
    TestDaemonThread2 t1=new TestDaemonThread2();
    TestDaemonThread2 t2=new TestDaemonThread2();
    t1.start();
    t1.setDaemon(true);     //will throw IllegalThreadStateException here  
    t2.start();
}
```

---
[Home](https://github.com/Piyushresonit/JavaCoreConcepts/blob/master/README.md)