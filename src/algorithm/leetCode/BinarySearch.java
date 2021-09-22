package algorithm.leetCode;

import java.util.stream.IntStream;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(IntStream.of(-1,0,3,5,9,12).toArray(), -1));
    }

    public static int search(int[] nums, int target) {
        int answer = -1;

        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else {
                if(nums[mid] > target) {
                    // search for left
                    end = mid - 1;
                } else {
                    // search for right
                    start = mid + 1;
                }
            }
        }
        return answer; 
    }
}
