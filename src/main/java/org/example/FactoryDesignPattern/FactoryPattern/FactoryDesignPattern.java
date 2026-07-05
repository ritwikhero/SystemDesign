package org.example.FactoryDesignPattern.FactoryPattern;

//interface for Burger / product
interface Burger{
    void prepare();
}

//concrete class for burger
class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic Burger");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Standard Burger");
    }
}

class PremimumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premimum Burger");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Basic Wheat Burger");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Standard Wheat Burger");
    }
}

class PremimumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Premimum Wheat Burger");
    }
}


//interface for burgerFactor / productFactory
interface BurgerFactory{
    Burger createBurger(String type);
}

//concrete class for BurgerFactory
class SinghBurger implements BurgerFactory {
    @Override
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premimum")) {
            return new PremimumBurger();
        }
        else{
            System.out.println("Invalid Singh burger type...");
            return null;
        }
    }
}

class  KingBurger implements BurgerFactory {
    @Override
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("basic")){
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premimum")) {
            return new PremimumWheatBurger();
        }
        else{
            System.out.println("Invalid King burger type...");
            return null;
        }
    }
}




public class FactoryDesignPattern {
    public static void main(String[] args) {
        BurgerFactory factory = new SinghBurger();
        Burger burger = factory.createBurger("premimum");

        BurgerFactory factory1  = new KingBurger();
        Burger burger1 = factory1.createBurger("premimum");

        if(burger != null){
            burger.prepare();
        }

        if(burger1 != null){
            burger1.prepare();
        }

    }
}
