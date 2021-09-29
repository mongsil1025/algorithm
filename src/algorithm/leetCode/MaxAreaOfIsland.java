package algorithm.leetCode;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int answer = maxAreaOfIsland(grid);
        System.out.println(answer);

    }
    public static int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == -1) {
                    continue;
                }
                // find 4-directionally
                int cnt = dfs(grid, i, j);
                answer = answer < cnt ? cnt : answer;
            }
        }
        return answer;
    }

    private static int dfs(int[][] grid, int r, int c) {
        int count = 0;
        if(grid[r][c] == 1) {
            count++;
            grid[r][c] = -1;
            
            if(r >= 1) count += dfs(grid, r-1, c);
            if(c >= 1) count += dfs(grid, r, c-1);
            if(r + 1 <grid.length) count += dfs(grid, r+1, c);
            if(c + 1 < grid[0].length) count += dfs(grid, r, c+1);
        }
        return count;
    }
}
