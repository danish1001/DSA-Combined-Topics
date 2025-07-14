package Graph.Questions;

import java.util.*;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        return traverse(image, sr, sc, image[sr][sc], newColor);
    }

    public int[][] traverse(int[][] image, int sr, int sc, int oldColor, int newColor) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sr, sc));
        image[sr][sc] = newColor;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while(!q.isEmpty()) {
            pair p = q.poll();
            int x = p.row;
            int y = p.col;

            for(int ind = 0; ind < 4; ind++) {
                int tx = x + dx[ind];
                int ty = y + dy[ind];
                if(tx >= 0 && ty >= 0 && tx < image.length && ty < image[0].length && image[tx][ty] == oldColor) {
                    q.add(new pair(tx, ty));
                    image[tx][ty] = newColor;
                }

            }

        }
        return image;
    }

    public class pair {
        int row;
        int col;
        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
