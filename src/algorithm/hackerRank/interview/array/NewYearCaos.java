package algorithm.hackerRank.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewYearCaos {

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int size = q.size();

        List<Integer> list = new ArrayList<>();
        
        IntStream.rangeClosed(1, size).forEach(x -> {
            list.add(x);
        });

        int total_bribe = 0;
        for(int i=0; i<size; i++) {

            int origin = list.get(0);
            // list.removeIf(x -> x.equals(origin));
            if(origin == q.get(i)) {
                // PASS
                list.remove(0);
            } else {
                int index = list.indexOf(q.get(i));
                if(index == 1 || index == 2) {
                    list.remove(q.get(i));
                    total_bribe += index;
                } else {
                    System.out.println("Too chaotic");
                    return; // exit
                }
             }

        }

        System.out.println(total_bribe);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
