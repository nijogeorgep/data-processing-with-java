/**
 *
 */
package com.cloudwalker.collections.udemy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nijogeorgep
 *
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        if (languages.containsKey("HINDI")) {
            System.out.println("Hindi Already Exists");
        } else {
            languages.put("HINDI", "INDIA");
            System.out.println("Hindi added Successfully");
        }

        languages.put("ENGLISH", "ENGLAND");
        languages.put("ARABIC", "UAE");
        languages.put("RUSSIAN", "RUSSIA");

        System.out.println(languages.put("SPANISH", "SPAIN"));
        System.out.println(languages.put("FRENCH", "FRANCE"));

        System.out.println(languages.get("HINDI"));

        if (languages.containsKey("HINDI")) {
            System.out.println("Hindi Already Exists in the Map");
        } else {
            languages.put("HINDI", "INDIAN LANGUAGE");
            // System.out.println(languages.put("HINDI", "INDIAN LANGUAGE"));
            System.out.println("Hindi added Successfully");
        }

        System.out.println(languages.get("HINDI"));

        languages.remove("ARABIC");
        if (languages.remove("SPANISH", "LANGUAGE OF SPAIN")) {
            System.out.println("Spanish Removed");
        } else {
            System.out.println("Spanish Not Removed, Key/Value Pair Not Found");
        }

        System.out.println(languages.replace("FRENCH", "Language of France"));
        System.out.println(languages.replace("MALAYALAM", "This one won't be added"));

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
