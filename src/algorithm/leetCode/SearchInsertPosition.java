package algorithm.leetCode;

import java.util.stream.IntStream;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(IntStream.of(1,3,5,6).toArray(), 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int minDiffIndex = 0;
        int minDiff = Integer.MAX_VALUE;
        
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                start = mid + 1; // search for right
                if(Math.abs(target - nums[mid])  < minDiff) {
                    minDiff = Math.abs(target - nums[mid]);
                    minDiffIndex = mid;
                }
            } else {
                end = mid - 1;
                if(Math.abs(target - nums[mid]) < minDiff) {
                    minDiff = Math.abs(target - nums[mid]);
                    minDiffIndex = mid;
                }
            }
        }
        if(nums[minDiffIndex] > target) {
            return minDiffIndex;
        } else {
            return minDiffIndex + 1;
        }
    }


}
