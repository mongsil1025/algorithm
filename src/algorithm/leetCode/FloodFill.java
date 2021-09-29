package algorithm.leetCode;

public class FloodFill {
    public static void main(String[] args) {
        
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];
        if(color != newColor) dfs(sr, sc, color, newColor, image);
        
        return image;
    }

    private static void dfs(int r, int c, int color, int newColor, int[][] image) {
        if(image[r][c] == color) {
            image[r][c] = newColor; 
            if(r >= 1) dfs(r-1, c, color, newColor, image); // north
            if(c >= 1) dfs(r, c-1, color, newColor, image); // west
            if(r+1 < image.length) dfs(r+1, c, color, newColor, image); // south
            if(c+1 < image[0].length) dfs(r, c+1, color, newColor, image); // east
        }
    }
}
