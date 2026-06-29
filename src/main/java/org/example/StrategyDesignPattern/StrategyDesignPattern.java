package org.example.StrategyDesignPattern;

import java.sql.SQLOutput;

//strategy walkable interface
interface Walkable{
    void walk();
}

//concrete class for walkable interface
class NormalWalk implements Walkable{
    @Override
    public void walk() {
        System.out.println("Walking normally ...");
    }
}

class NonWalkable implements Walkable{
    @Override
    public void walk() {
        System.out.println("Not walking ....");
    }
}

//Strategy for flyable interface
interface Flyable{
    void fly();
}

//concrete class implementation for flyable interface
class NormalFlyable implements Flyable{
    @Override
    public void fly() {
        System.out.println("Flying normally ...");
    }
}

class NonFlyable implements Flyable{
    @Override
    public void fly() {
        System.out.println("Not able to Fly ....");
    }
}

//interface for Talkable strategy
interface Talkable{
    void talk();
}

//concrete class implementation for talkable strategy
class NormalTalkable implements Talkable{
    @Override
    public void talk(){
        System.out.println("Normal talking ....");
    }
}

class NonTalkable implements Talkable{
    @Override
    public void talk() {
        System.out.println("Not able to talk ...");
    }
}

abstract class Robot{
    private Walkable walkBehaviour;
    private Talkable talkBehaviour;
    private Flyable flyBehaviour;

    public Robot(Walkable w, Talkable t, Flyable f){
        this.walkBehaviour = w;
        this.talkBehaviour = t;
        this.flyBehaviour = f;
    }

    public void walk(){
        walkBehaviour.walk();
    }

    public void talk(){
        talkBehaviour.talk();
    }

    public void fly(){
        flyBehaviour.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot{
    public CompanionRobot(Walkable w, Talkable t, Flyable f){
        super(w,t,f);
    }

    @Override
    public void projection() {
        System.out.println("Companion robot behaviour...");
    }
}

class WorkerRobot extends Robot{
    public WorkerRobot(Walkable w, Talkable t, Flyable f){
        super(w,t,f);
    }

    @Override
    public void projection() {
        System.out.println("Worker robot behaviour...");
    }
}

public class StrategyDesignPattern {
    public static void main(String[] args) {

        Robot robo1 = new CompanionRobot(new NormalWalk(), new NormalTalkable(), new NormalFlyable());
        robo1.walk();
        robo1.talk();
        robo1.fly();
        robo1.projection();

        Robot robo2 = new WorkerRobot(new NonWalkable(), new NonTalkable(), new NonFlyable());
        robo2.walk();
        robo2.talk();
        robo2.fly();
        robo2.projection();

    }
}
