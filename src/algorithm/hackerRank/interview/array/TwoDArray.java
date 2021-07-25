package algorithm.hackerRank.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoDArray {
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here

        List<Integer> flatList = arr.stream().flatMap(inner -> inner.stream())
                                             .collect(Collectors.toList());

        int answer = Integer.MIN_VALUE;
        
        for(int j=0; j<4; j++) {

            for(int i=0; i<4; i++) {
                int sum = 0;

                sum += flatList.get((6 * (j+0)) + i);
                sum += flatList.get((6 * (j+0)) + i + 1);
                sum += flatList.get((6 * (j+0)) + i + 2);
    
                sum += flatList.get((6 * (j+1)) + i + 1);
    
                sum += flatList.get((6 * (j+2)) + i);
                sum += flatList.get((6 * (j+2)) + i + 1);
                sum += flatList.get((6 * (j+2)) + i + 2);

                if(answer < sum) {
                    answer = sum;
                }
            }
        }

        return answer;
    }    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = hourglassSum(arr);
        System.out.println(result);

    }
}
