package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }

    public static void letterCasePermutation(String s) {
        
        char[] charList = s.toCharArray();
        
        List<String> answer = new ArrayList<>();
        recursive(charList, answer, 0);
        System.out.println(answer.toString());

    }

    public static void recursive(char[] list, List<String> finalList, int i) {
        if(i == list.length) {
            finalList.add(String.valueOf(list));
            return;
        }

        // 소문자 -> 대문자로 변경
        if(Character.isLetter(list[i])){

            list[i] = Character.toUpperCase(list[i]);
            recursive(list, finalList, i + 1);
            list[i] = Character.toLowerCase(list[i]);
            recursive(list, finalList, i + 1);
        } else {
            recursive(list, finalList, i + 1);
        }
        
    }

    public static int hasUpperCase(char[] list) {
        for(int i=0; i<list.length; i++) {
            if(list[i] >= 65 && list[i] <= 90) {
                return i;
            }
        }
        return -1;
    }

    public static int hasLowerCase(char[] list) {
        for(int i=0; i<list.length; i++) {
            if(list[i] >= 97 && list[i] <= 122) {
                return i;
            }
        }
        return -1;
    }
}
