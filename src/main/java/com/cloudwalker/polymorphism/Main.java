/**
 *
 */
package com.cloudwalker.polymorphism;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out
                    .println("Movie #" + i + " : " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
        }

    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("RandomNumberGenerated :" + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new Mayanadhi();
            case 3:
                return new TheWalk();
            case 4:
                return new Avengers();
            case 5:
                return new Forgetable();
        }
        return null;
    }

}


/**
 * Movie Class
 */
class Movie {
    private String name;

    /**
     * @param name
     */
    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No Plot Here";
    }

    public String getName() {
        return name;
    }
}


class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats lots of people";
    }
}


class Mayanadhi extends Movie {

    public Mayanadhi() {
        super("Mayanadhi");
    }

    @Override
    public String plot() {
        return "Unordinary Love Story";
    }

}


class TheWalk extends Movie {

    public TheWalk() {
        super("The Walk");
    }

    @Override
    public String plot() {
        return "True Story of a Wire-Walker";
    }
}


class Avengers extends Movie {

    public Avengers() {
        super("Avengers");
    }

    @Override
    public String plot() {
        return "Story of a group of Extra ordinary skills";
    }

}


class Forgetable extends Movie {

    public Forgetable() {
        super("Forgetable");
    }
    // No Plot Method
}
