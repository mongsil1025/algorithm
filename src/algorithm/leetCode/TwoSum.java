package algorithm.leetCode;

import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = twoSum(IntStream.of(0, 0, 3, 4).toArray(), 0);
        for(int i : array) {
            System.out.print(i + ",");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        int p1 = 0;
        int p2 = numbers.length - 1;

        while(p1 < p2) {
            int check = target - numbers[p1];
            if(check == numbers[p2]) {
                break;
            }
            if(check < numbers[p2]) {
                p2 --;
            }
            if(check > numbers[p2]) {
                p1 ++;
            }

        }

        answer[0] = p1 + 1;
        answer[1] = p2 + 1;

        return answer;
    }
}
