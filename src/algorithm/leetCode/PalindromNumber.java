package algorithm.leetCode;

import java.util.stream.Stream;

public class PalindromNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-131));
    }

    public static boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        boolean answer = true;
        int temp = x;

        int[] digits = Stream.of(String.valueOf(x).split("")).mapToInt(Integer::parseInt).toArray();

        for(int digit : digits) {
            if(temp % 10 != digit) {
                answer = false;
                break;
            }
            temp /= 10;
        }

        return answer;
    }
}
