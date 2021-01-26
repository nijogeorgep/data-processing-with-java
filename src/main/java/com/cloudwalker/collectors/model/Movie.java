/**
 *
 */
package com.cloudwalker.collectors.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nijogeorgep
 *
 */
public class Movie {
    private String title;
    private int releaseYear;

    private Set<Actor> actors = new HashSet<>();

    /**
     * @param title
     * @param releaseYear
     */
    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * @param releaseYear the releaseYear to set
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * @return the actors
     */
    public Set<Actor> actors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void addActors(Actor actor) {
        this.actors.add(actor);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Movie [title=");
        builder.append(title);
        builder.append(", releaseYear=");
        builder.append(releaseYear);
        builder.append(", actors=");
        builder.append(actors);
        builder.append("]");
        return builder.toString();
    }

}
