package com.cloudwalker.annotations;

import com.cloudwalker.reflection.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaAnnotations {
    public static void main (String args[]) throws Exception {

        Animal myAnimal = new Animal("Cat",3);

        @SuppressWarnings("unused")
        Cat myCat = new Cat("Makri",4);

        if(myAnimal.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("This is very Important");
        } else {
            System.out.println("This is not very Important");
        }

        for(Method method : myAnimal.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i=0; i< annotation.times();i++) {
                    method.invoke(myAnimal);
                }
                for(int i=0; i< annotation.repeat();i++) {
                    method.invoke(myAnimal);
                }
            }
        }

        for(Field field : myAnimal.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                Object objValue=field.get(myAnimal);
                if(objValue instanceof String stringValue){
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
