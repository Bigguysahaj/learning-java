class MyRunnable implements Runnable {
    @Override
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
        // Create new threads
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());
        
        // Start the threads
        thread1.start();
        
        // Wait for thread1 to complete before starting thread2 and thread3
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        thread2.start();
        
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
        
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
