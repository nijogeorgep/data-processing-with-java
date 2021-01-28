package com.cloudwalker.collections;

import com.cloudwalker.interfaces.trade.Trade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author nijogeorgep
 */
public class StreamApiDemos {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("a");
        list.add("");

        // Iterating
        boolean IsExist = list.stream().anyMatch(element -> element.contains("a"));
        System.out.println("Element Exists : " + IsExist);

        // Filtering
        Stream<String> elementsList = list.stream().filter(element -> element.contains("d"));
        elementsList.forEach(element -> System.out.println(element));

        // Matching
        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        System.out.println("Element Matches : " + isValid);
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        System.out.println("Element Matches : " + isValidOne);
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
        System.out.println("Element Matches : " + isValidTwo);

        // Reduction
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        System.out.println("Reduced Value :" + reduced);

        // Mapping
        Trade myTrade = new Trade();
        myTrade.setIssuer("VGUARD");
        myTrade.setQuantity(13367939);
        myTrade.setStatus("ARCHIVED");
        myTrade.setItems(Arrays.asList("AB", "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR", "ST", "UV",
                "WX", "YZ"));
        List<Trade> tradesCollection = new ArrayList<Trade>();

        tradesCollection.add(myTrade);

        Stream<String> tradeStream =
                tradesCollection.stream().flatMap(detail -> detail.getItems().stream());
        tradeStream.forEach(System.out::println);

        // Stream.builder()
        Stream<String> streamBuilder = Stream.<String>builder().add("NIJO").add("GEORGE")
                .add("PAYYAPPILLY").add("ELENTHIKKARA").build();
        streamBuilder.forEach(System.out::println);

        // Stream.generate()
        Stream<String> streamGenerate = Stream.generate(() -> "CloudWalkers").limit(10);
        streamGenerate.forEach(System.out::println);

        // Stream.iterate()
        Stream<Integer> iteratedStream = Stream.iterate(40, n -> n * 2).limit(10);
        iteratedStream.forEach(System.out::println);

        String someString = "elephant";
        long count = someString.chars().filter(ch -> ch == 'a').count();
        long count2 = someString.codePoints().filter(ch -> ch == 'e').count();
        System.out.println(count + "--" + count2);
    }
}
