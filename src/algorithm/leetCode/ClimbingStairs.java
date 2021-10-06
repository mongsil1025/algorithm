package algorithm.leetCode;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }   

    public static int climbStairs(int n) {
        int a = 0;
        int b = 1;
        
        while (n > 0) {
            int tmp = a;
            a = b;            
            b = tmp + b;
            n -= 1;
        }
        
        return b;
    }
}
