package algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        String answer = "";

        // initialize frequency table for t
    
        Map<Character, Integer> hashMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            hashMap.compute(c, (k,v) -> (v == null) ? 1 : v + 1);
        }

        // intialize sliding window
        int begin = 0, end = 0;
        int counter = hashMap.keySet().size();
        int len = Integer.MAX_VALUE;

        while(end < s.length()) {
            char endChar = s.charAt(end);

            if(hashMap.containsKey(endChar)) {
                hashMap.put(endChar, hashMap.get(endChar) - 1);
                if(hashMap.get(endChar) == 0) counter--;
            }

            end ++;

            while(counter == 0) {
                if(end - begin < len) {
                    len = end - begin;
                    answer = s.substring(begin, end);
                }

                // check for begin character
                if(hashMap.containsKey(s.charAt(begin))) {
                    hashMap.compute(s.charAt(begin), (k,v) -> v + 1);
                    if(hashMap.get(s.charAt(begin)) > 0) {
                        counter++;
                    }
                }

                begin ++;
            }

        }

        return answer;
    }
}
