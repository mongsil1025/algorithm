package algorithm.leetCode;

import java.util.stream.IntStream;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] answer = sortedSquares(IntStream.of(-2, -1, 3).toArray());
        for(int x : answer){
            System.out.print(x + ", ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];

        int p1 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        int size = nums.length - 1;

        while(p1 < p2) {
            int sqr1 = nums[p1] * nums[p1];
            int sqr2 = nums[p2] * nums[p2];

            if(sqr1 > sqr2) {
                answer[size - index++] = sqr1;
                p1++;
            } else {
                answer[size - index++] = sqr2;
                p2--;
            }

        }

        if(p1 == p2) {
            answer[size - index] = nums[p1] * nums[p1];
        }
        return answer;
    }
}
