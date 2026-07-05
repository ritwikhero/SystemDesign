package org.example.FactoryDesignPattern.AbstractFactory;

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

interface GarlicBread{
    void prepareGarlicBread();
}

class BasicGarlicBread implements GarlicBread{
    @Override
    public void prepareGarlicBread() {
        System.out.println("Basic Garlic Bread");
    }
}

class CheeseGarlicBread implements GarlicBread{
    @Override
    public void prepareGarlicBread() {
        System.out.println("Cheese Garlic Bread");
    }
}

class BasicWheatGarlicBread implements GarlicBread{
    @Override
    public void prepareGarlicBread() {
        System.out.println("Basic Wheat Garlic Bread");

    }
}

class CheeseWheatGarlicBread implements GarlicBread{
    @Override
    public void prepareGarlicBread() {
        System.out.println("Cheese Wheat Garlic Bread");
    }
}


//interface for burgerFactor / productFactory
interface MealFactory{
  Burger createBurger(String type);
  GarlicBread createGarlicBread(String type);

}

//concrete class for BurgerFactory
class SinghMeal implements MealFactory {
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

    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new BasicGarlicBread();
        } else if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();

        } else{
            System.out.println("Invalid Singh Garlic Bread type...");
            return null;
        }
    }
}

class  KingMeal implements MealFactory {
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

    @Override
    public GarlicBread createGarlicBread(String type) {
            if(type.equalsIgnoreCase("basic")){
                return new BasicWheatGarlicBread();
            } else if (type.equalsIgnoreCase("cheese")) {
                return new CheeseWheatGarlicBread();

            } else{
                System.out.println("Invalid King Garlic Bread type...");
                return null;
            }
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        MealFactory mealFactory = new SinghMeal();
        Burger burger = mealFactory.createBurger("basic");
        GarlicBread garlicBread = mealFactory.createGarlicBread("basic");

        MealFactory mealFactory1 = new KingMeal();
        Burger burger1 = mealFactory1.createBurger("premimum");
        GarlicBread garlicBread1 = mealFactory1.createGarlicBread("cheese");

        if(burger != null && garlicBread != null && burger1 != null && garlicBread1 != null){
            burger.prepare();
            garlicBread.prepareGarlicBread();
            burger1.prepare();
            garlicBread1.prepareGarlicBread();
        }


    }
}
