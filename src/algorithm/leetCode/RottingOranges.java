package algorithm.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh_orages_count = 0;
        int time = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) fresh_orages_count ++;
                if (grid[i][j] == 2) queue.offer(new int[] {i, j});
            }
        }

        if(fresh_orages_count == 0) return time;

        while(!queue.isEmpty()) {
            time ++; // start rotting :(

            int queue_size = queue.size();
            for(int i=0; i<queue_size; i++) {
                int[] rotten = queue.poll();

                // search for 4 direction
                int x = rotten[0]; int y = rotten[1];
    
                if(x > 0) {
                    if(grid[x-1][y] == 1) {
                        fresh_orages_count --;
                        grid[x-1][y] = 2;
                        queue.add(new int[] {x-1, y});
                    }
                }
                if(x < grid.length - 1) {                
                    if(grid[x+1][y] == 1) {
                        fresh_orages_count --;
                        grid[x+1][y] = 2;
                        queue.add(new int[] {x+1, y});
                    }
                }
                if(y > 0) {
                    if(grid[x][y-1] == 1) {
                        fresh_orages_count --;
                        grid[x][y-1] = 2;
                        queue.add(new int[] {x, y-1});
                    }
                }
                if(y < grid[0].length - 1) {                
                    if(grid[x][y+1] == 1) {
                        fresh_orages_count --;
                        grid[x][y+1] = 2;
                        queue.add(new int[] {x, y+1});
                    }
                }
            }
        }

        return fresh_orages_count == 0 ? time - 1 : -1;

    }
}
