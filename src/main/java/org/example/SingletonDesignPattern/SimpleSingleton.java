package org.example.SingletonDesignPattern;

public class SimpleSingleton {
    private static  SimpleSingleton instance = null;

    private SimpleSingleton(){
        System.out.println("Simple Singleton Constructor called");
    }

    public static SimpleSingleton getInstance(){
        if(instance == null){
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        SimpleSingleton s1 = new SimpleSingleton();
        SimpleSingleton s2 = new SimpleSingleton();

        System.out.println(s1 == s2);
    }
}
