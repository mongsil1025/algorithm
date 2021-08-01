package algorithm.leetCode;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int target = -100;
        int[] ary = new int[] {1,1,1,0};

        boolean[] visited = new boolean[ary.length];
        System.out.println(combination(ary, visited, 0, ary.length, 3, target));
        
        
    }

    public static int combination(int[] arr, boolean[] visited, int start, int n, int r, int target) {
        int sum = 0;
        int answer = arr[0] + arr[1] + arr[2];
        
        if(r == 0) {
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }

            return sum;
        }

        for(int i=start; i<n; i++) {
            if(start > n - 3 && r-1 == 0) {
                break;
            }
            visited[i] = true;
            sum = combination(arr, visited, i + 1, n, r - 1, target);
            answer = Math.abs(target - sum) < Math.abs(target - answer) ? sum : answer ;
            visited[i] = false;
        }

        return answer;
    }
}