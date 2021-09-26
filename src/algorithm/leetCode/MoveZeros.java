package algorithm.leetCode;

import java.util.stream.IntStream;

public class MoveZeros {
    public static void main(String[] args) {
        int[] array = IntStream.of(1).toArray();
        moveZeroesOptimal(array);
        for(int i : array) {
            System.out.print(i + ",");
        }
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int p1 = 0;
        int p2 = 0;

        int zero_count = 0;
        while(p2 < length && p1 <= p2) {
            if(nums[p2] == 0){
                p1 = p2;
                zero_count ++;
            }
            if(zero_count > 0 && nums[p2] != 0) {
                // swap
                nums[p1 - (zero_count-1)] = nums[p2];
                nums[p2] = 0;
                p1 = p2;
            }
            p2 ++;
        }
    }

    public static void moveZeroesOptimal(int[] nums) {
        for(int lastNonZeroFound =0, cur=0; cur<nums.length; cur++) {
            if(nums[cur] != 0) {
                int temp = nums[lastNonZeroFound];
                nums[lastNonZeroFound] = nums[cur];
                nums[cur] = temp;
                lastNonZeroFound++;
            }
        }
    }
}
