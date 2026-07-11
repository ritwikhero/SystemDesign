package org.example.SingletonDesignPattern;

public class ThreadSafeDoubleLockingSingleton {

    private static ThreadSafeDoubleLockingSingleton instance = null;

    private ThreadSafeDoubleLockingSingleton(){
        System.out.println("Singleton Double locking constructor called");
    }

    //double locking check
    private static ThreadSafeDoubleLockingSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeDoubleLockingSingleton.class){
                if(instance == null){
                    instance = new ThreadSafeDoubleLockingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeDoubleLockingSingleton s1 = new ThreadSafeDoubleLockingSingleton();
        ThreadSafeDoubleLockingSingleton s2 = new ThreadSafeDoubleLockingSingleton();

        System.out.println(s1 == s2);
    }
}
