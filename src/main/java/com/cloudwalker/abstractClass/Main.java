/**
 * Inheritance refers to an IS-A relationship where a class (called superclass) provides common
 * attributes and methods to derived or more specialized classes (called subclass). Here are the
 * things you can do in a subclass: Inherited attributes can be used directly, just like any other.
 * An attribute can be declared in the subclass with the same name as the one in the superclass,
 * thus hiding it. New attributes that are not in the superclass can be declared in the subclass.
 * Inherited methods can be used directly as they are. A new instance method can be declared in the
 * subclass that has the same signature as the one in the superclass, thus overriding it. A new
 * static method can be declared in the subclass that has the same signature as the one in the
 * superclass, thus hiding it. New methods that are not in the superclass can be declared in the
 * subclass. A constructor can be declared in the subclass that invokes the constructor of the
 * superclass, either implicitly or by using the keyword super. The method signature is the name of
 * the method and the list of its parameters (types and number of parameters included). Return types
 * are not included in this definition. We talk about overloading when a method changes the list of
 * parameters of another method (that might be inherited) while keeping the same name. We talk about
 * overriding when the method signature is the same, but for some reason, we want to redefine an
 * INSTANCE method in the subclass. The most important methods of java.lang.Object that most classes
 * must redefine are: public int hashCode() public boolean equals(Object obj) public String
 * toString() With polymorphism, subclasses can define their own behaviors (different than the ones
 * of the methods of the superclass), and the JVM will call the appropriate method for the object.
 * This behavior is referred to as virtual method invocation. Abstract classes CANNOT be
 * instantiated, only subclassed. Abstract methods are declared WITHOUT an implementation (body).
 * The abstract keyword can only be applied to classes or non-static methods. An abstract class
 * doesn't need to declare abstract methods to be declared abstract. If a class includes abstract
 * methods, then the class itself must be declared abstract. If the subclass of an abstract class
 * doesn't provide an implementation for all abstract methods, the subclass must also be declared
 * abstract. Methods of an interface are considered abstract, so an abstract class that implements
 * an interface can implement some or none of the interface methods.
 */
package com.cloudwalker.abstractClass;

/**
 * @author nijogeorgep
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyNewClass myNewClass = new MyNewClass();
        myNewClass.getNames();
        myNewClass.getNumber();
        myNewClass.getSum();
        myNewClass.processInParallel();
    }
}
