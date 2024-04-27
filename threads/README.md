## Thread
Thread in Java represents a single path of execution within a program.
Java program can have multiple threads running concurrently

### Parts

- **Thread** : Represented by instances for Thread class or implementing Runnable
- **Runnable Interface** : The Runnable interface defines a single method, run(), which contains the code that the thread will execute when it is started.
- **Thread Lifecycle** :  NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, and TERMINATED.
- **Thread Synchronization** : Helps sychronize resources, to ensure only one thread can access shared resources at a time.

### Creating a Thread in Java

```java
class MyThread extends Thread {
    public void run() {
        // Code to be executed by the thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new thread
        MyThread thread1 = new MyThread();
        
        // Start the thread
        thread1.start();
        
        // Main thread continues its execution
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

The main method continues exectution alongside the thread1, like following:

```
main: 0
Thread-0: 0
main: 1
Thread-0: 1
main: 2
Thread-0: 2
main: 3
Thread-0: 3
main: 4
Thread-0: 4

=== Code Execution Successful ===
```
- But saddly, can't always extend Thread, so have to implement Runnable
  - ```java
    class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed by the thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new thread
        Thread thread1 = new Thread(new MyRunnable());
        
        // Start the thread
        thread1.start();
        
        // Main thread continues its execution
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```
  - Race condition, concurrent update of shared variable can lead to data inconsistency
  - Critical sections, sections of code where shared variables are updated
  - Mutual exclustions ; at most one thread at a time can be in a critical section

- Semaphores : semaphores is like a variable
