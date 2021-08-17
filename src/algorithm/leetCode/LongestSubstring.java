package algorithm.leetCode;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(secondApproach(s));
    }

    public static int firstApproach(String s) {
        int answer = 0;
        int length = s.length();
        for(int i=0; i<length; i++) {
            int size = lengthOfLongestSubstring(s.substring(i));
            if (size == length) {
                answer = size;
                break;
            }
            answer = answer < size ? size : answer;
        }
        return answer;
    }

    public static int lengthOfLongestSubstring(String s) {

        boolean[] char_set = new boolean[128];
        int size = 0;

        for(char c : s.toCharArray()) {
            if(char_set[c]) {
                break;
            } else {
                char_set[c] = true;
                size ++;
            }
        }

        return size;
    }

    public static int secondApproach(String s) {
        int result = 0;
        int[] cache = new int[128];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
