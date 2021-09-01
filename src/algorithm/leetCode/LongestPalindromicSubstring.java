package algorithm.leetCode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
 
    public static String longestPalindrome(String s) {

        // babad
        // bacebad
        // bacab

        // Palindrom Condition
        // 1. s의 전체 길이가 홀수이면, 1개의 문자를 제외한 모든 문자가 짝수번 나와야한다.
        // 2. s의 전체 길이가 짝수라면, 모든 문자가 짝수번 등장해야 한다.

        if(s == null || s.length() < 1) {
            return null;
        }

        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandFromMiddle(s, i, i); // start from myself
            int len2 = expandFromMiddle(s, i, i+1); // start from me and right

            int max = Math.max(len1, len2);
            if(max > end - start) {
                start = i - ((max  - 1) / 2);
                end = i + (max / 2);
            }

        }
        
        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;
    }
}
