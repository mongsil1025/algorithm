package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> answer = new ArrayList<>();
        
        int n = 4; int k = 2;

        dfs(n, k, 1, new ArrayList<>(), answer);

        System.out.println(answer.toString());
        
    }

    
    public static void dfs(int n, int k, int cur, List<Integer> list, List<List<Integer>> finalList) {

        if(k == 0) {
            finalList.add(new ArrayList<>(list));
            return;
        }

        for(int i=cur; i<n+1; i++) {
            list.add(i);
            dfs(n, k-1, i+1, list, finalList);
            list.remove(list.size() - 1);
        }

    }
}
