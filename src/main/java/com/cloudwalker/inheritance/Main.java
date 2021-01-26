/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 50);

        Dog dog = new Dog("Jimmy", 11, 45, 1, 4, 20, 1, "Silky Back");

        // System.out.println(dog.getName());

        dog.eat();

        // dog.walk();

        dog.run();

        Fish fish = new Fish("Nemo", 1, 3, 1, 2, 2);

        fish.swim(7);

        Huski huski = new Huski("Jaime", 5, 160, 2, 4, 30, 1, "Silky White");

        huski.bark();

        // Demonstrate how static variable works
        Person rex = new Person("Rex");
        rex.printName();
        Person fluffy = new Person("Fluffy");
        rex.printName();
        fluffy.printName();

    }
}
