package org.example.FacrtoryDesignPattern;

interface Burger{
    void prepare();
}
class BasicBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Basic burger...");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Standard Burger...");
    }
}

class PremimumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Permimum Burger...");
    }
}

class BurgerFactory{
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();

        } else if (type.equalsIgnoreCase("permimum")) {
            return new PremimumBurger();
        }
        else {
            System.out.println("Invalid burger type ! please enter correct type.");
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        BurgerFactory myBurgerFactory = new BurgerFactory();

        Burger burger = myBurgerFactory.createBurger("Basic");

        if(burger != null){
            burger.prepare();
        }
    }
}
