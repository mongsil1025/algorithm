package algorithm.hackerRank.interview.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Magazine {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Long> countMap = magazine.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String n : note) {

            if(countMap.containsKey(n)) {
                if(countMap.get(n) <= 0) {
                    System.out.println("No");
                    return;
                } else {
                    countMap.put(n, countMap.get(n) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    
    }

    public static void checkMagazineWithStream(List<String> magazine, List<String> note) {
        Map<String, Long> map = note.stream()
                                    .collect(Collectors.groupingBy(Function.identity()
                                                                    , Collectors.filtering(word -> magazine.contains(word), Collectors.counting())));

        System.out.println(map);

        for(String n : note) {
            Long count = map.get(n);

            if(count == 0) {
                System.out.println("No");
                return;
            } else {
                map.put(n, count-1);
            }
        }
        System.out.println("Yes");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(Collectors.toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(Collectors.toList());

            checkMagazineWithStream(magazine, note);

        bufferedReader.close();
    }
}