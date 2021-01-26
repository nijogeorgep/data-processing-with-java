/**
 *
 */
package com.cloudwalker.algorithms;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author nijogeorgep
 *
 */
public class DictionaryDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<String, Integer> dictionary = Collections.synchronizedMap(new TreeMap<String, Integer>());

        Set<Entry<String, Integer>> set = dictionary.entrySet();

        Iterator<Entry<String, Integer>> entryItr = set.iterator();

        Entry<String, Integer> entry = null;

        while (entryItr.hasNext()) {
            entry = entryItr.next();
            // Do whatever you want.
        }


        Hashtable<String, Set<String>> dictHashtable = new Hashtable<>();
        Set<String> meaningSet = new HashSet<>();
        dictHashtable.put("MyKey", meaningSet);


    }

}
