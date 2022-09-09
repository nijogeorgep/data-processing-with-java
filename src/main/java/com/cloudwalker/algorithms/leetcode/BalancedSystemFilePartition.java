package com.cloudwalker.algorithms.leetcode;


import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result2 {

    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here
        return 0;
    }

}

public class BalancedSystemFilePartition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> parent = IntStream.range(0, parentCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int files_sizeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> files_size = IntStream.range(0, files_sizeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.mostBalancedPartition(parent, files_size);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
