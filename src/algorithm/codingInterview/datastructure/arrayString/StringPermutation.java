package algorithm.codingInterview.datastructure.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 코딩인터뷰 p107
 * 주어진 문자열의 모든 순열을 계산하는 알고리즘을 설계하라
 * 최적화 기술 #4 : base case 로부터 확장하기
 * 
 */
public class StringPermutation {

    static List<List<String>> table = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // List<String> answer = permutation(str);
        // System.out.println(answer);

        solution(str);
        System.out.println(allSet);
        
    }

    public static List<String> permutation(String str) {
        if(str.length() == 1) return Arrays.asList(str);
        table.add(new ArrayList<>(Arrays.asList(String.valueOf(str.charAt(0))))); // init value
        permutation(str, 0, 1);
        return table.get(str.length() - 1);
    }

    public static void permutation(String org, int pre, int cur) {
        if(cur == org.length()) return; // 종료 TODO "a" 테스트

        List<String> list       = table.get(pre);
        List<String> new_list   = new ArrayList<>();

        for(String pre_string : list) {
            for(int i=0; i<pre_string.length() + 1; i++) {
                new_list.add(pre_string.substring(0, i) + String.valueOf(org.charAt(cur)) + pre_string.substring(i, pre_string.length()));
            }
        }
        table.add(new_list);
        permutation(org, cur, cur + 1);
    }

    /**
     * 인터넷에서 찾은 코드
     */

    public static HashSet<String> allSet;

    public static void solution(String s) {
        allSet = new HashSet<>();
        permutation("", s);
    }

    public static void permutation(String prefix, String s) {
        int n = s.length();
        if(n==0)
            allSet.add(prefix); // all에 삽입
        else {
            for(int i=0; i<n; i++) {
                permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1));
            }
        }
    }
}
