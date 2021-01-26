package com.cloudwalker.spliterator;

import com.cloudwalker.spliterator.model.Person;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 */

/**
 * @author nijogeorgep
 *
 */
public class PersonSpliterator implements Spliterator<Person> {

    private final Spliterator<String> lineSpliterator;
    private String name;
    private int age;
    private String city;

    /**
     *
     */
    public PersonSpliterator(Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        if (this.lineSpliterator.tryAdvance(line -> this.name = line)
                && this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line))
                && this.lineSpliterator.tryAdvance(line -> this.city = line)) {

            Person person = new Person(name, age, city);
            action.accept(person);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }


}
