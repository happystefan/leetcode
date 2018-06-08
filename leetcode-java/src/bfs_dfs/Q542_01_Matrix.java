package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q542_01_Matrix {

    public int[][] updateMatrix(int[][] matrix) {
    	Queue<int[]> Q = new LinkedList<>();
    	for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!Q.isEmpty()) {
    	    int[] ij = Q.poll();
    	    int i = ij[0], j = ij[1];
    	    for (int[] dir : dirs) {
    	        int ii = i+dir[0], jj = j+dir[1];
    	        if (ii < 0 || ii >= matrix.length || jj < 0 || jj >= matrix[0].length) {
    	            continue;
                }
                if (matrix[ii][jj] < matrix[i][j]+1) {
    	            continue;
                }
                matrix[ii][jj] = matrix[i][j]+1;
    	        Q.offer(new int[]{ii, jj});
            }
        }
        return matrix;
    }

}
