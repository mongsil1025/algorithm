package algorithm.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class HouseRobber {

    static int[] memo;
    public static void main(String[] args) {
        int answer = rob3(new int[] {1, 2, 3, 1});
        System.out.println(answer);
        assert answer != 17 : "Test Fail";
    }

    public static int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i) {

        System.out.print(i + " ");

        if( i < 0) return 0;
        if(memo[i] >= 0) return memo[i];

        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        System.out.print(Arrays.toString(memo));
        return result;
    }

    public static int rob3(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
