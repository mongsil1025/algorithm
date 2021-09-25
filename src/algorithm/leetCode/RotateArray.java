package algorithm.leetCode;

import java.util.stream.IntStream;


public class RotateArray {
    public static void main(String[] args) {
        int[] array = IntStream.of(1,2,3,4,5,6,7).toArray();
        rotate(array, 3);

        System.out.println(array);
    }
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k % length == 0) {
            return; // exit
        }
        
        // int[] answers = new int[length];
        // for(int i=0; i<length; i++) {
        //     answers[(i + k) % length] = nums[i];
        // }
        // for(int i=0; i<length; i++) {
        //     nums[i] = answers[i];
        // }

        for(int i=0; i < length/2; i++) {
            int to = nums[(i + k) % length];
            nums[(i + k) % length] = nums[i];
            nums[(i + 2*k) % length] = to;
        }
        if(length % 2 != 0) { // 홀수 일 경우
            nums[(length - 1 + k) % length] = nums[length - 1];
        }
        
    } 

    public static void swap(int from, int to, int step, int[] nums, int threshold) {
        if(to == threshold) {
            nums[to] = nums[from];
            return; // init return value
        }
        
        swap(to, ((to + step) % nums.length), step, nums, threshold);
        
        nums[to] = nums[from];

    }

    public static void rotate_2(int[] nums, int k) {
        int length = nums.length;
        if (k > length) k = k % length;
        int[] left = new int[length - k];
        int[] right = new int[k];

        for(int i=0; i<left.length; i++){
            left[i] = nums[i];
        }
        for(int i=0; i<right.length; i++){
            right[i] = nums[length - k + i];
        }
        reverse(left);
        reverse(right);

        for(int i=0; i<right.length; i++) {
            nums[i] = right[right.length - 1 - i];
        }
        for(int i=0; i < left.length; i++) {
            nums[i + k] = left[left.length - 1 - i];
        }
    }

    /**
     *  1. Reverse two array
            [7, 6, 5, 4, 3, 2, 1]
     *  2. Reverse each array
            [5, 6, 7] / [1, 2, 3, 4]
     * @param nums
     * @param k
     */
    public void rotate_with_oneplace(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);  // reverse the whole array
        reverse(nums, 0, k-1);  // reverse the first part
        reverse(nums, k, nums.length-1);  // reverse the second part
    }
    
    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}
