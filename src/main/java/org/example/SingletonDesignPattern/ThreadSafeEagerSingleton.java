package org.example.SingletonDesignPattern;

public class ThreadSafeEagerSingleton {

    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    private ThreadSafeEagerSingleton(){
        System.out.println("Eager Singleton Constructor called");
    }

    public static ThreadSafeEagerSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
