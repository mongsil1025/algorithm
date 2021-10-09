package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    static int[][] memo;
    public static void main(String[] args) {

        int[][] a = new int[][] {{2},{3,4},{6,5,7},{4,1,8,3}};

        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0; i<a.length; i++) {
            List<Integer> inner = new ArrayList<>();
            for(int j=0; j<a[i].length; j++) {
                inner.add(a[i][j]);
            }
            triangle.add(inner);
        }

        memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for(int i=0; i<memo.length; i++ ){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        

        int answer = minimumTotal(0, 0, triangle);

        System.out.println(answer);
    }

    public static int minimumTotal(int i, int j, List<List<Integer>> triangle) {
        
        if(i > triangle.size() - 1) return 0;

        int height = triangle.size();
        int width = triangle.get(i).size();
        if(i < height && j < width && memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        int answer = 0;

        System.out.println(i + ", " + j);

        int prev = minimumTotal(i+1, j, triangle);
        int right = minimumTotal(i+1, j+1, triangle);

        answer = Math.min(prev, right) + triangle.get(i).get(j);
        if(i < height && j < width) {
            memo[i][j] = answer;
        }
        return answer;
    } 
}
