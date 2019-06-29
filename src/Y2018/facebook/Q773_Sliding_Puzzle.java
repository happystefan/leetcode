package Y2018.facebook;

import java.util.*;

public class Q773_Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String target = toString(new int[][]{{1, 2, 3}, {4, 5, 0}});
        Set<String> visited = new HashSet<>();
        Queue<Node> Q = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0) {
                    continue;
                }
                Q.offer(new Node(board, i, j));
                break;
            }
        }
        int result = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                Node node = Q.poll();
                int[][] curr = node.board;
                int i = node.i, j = node.j;
                String str = toString(curr);
                if (str.equals(target)) {
                    return result;
                }
                visited.add(str);
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || ii >= 2 || jj < 0 || jj >= 3) {
                        continue;
                    }
                    int[][] next = swap(curr, i, j, ii, jj);
                    if (visited.contains(toString(next))) {
                        continue;
                    }
                    Q.offer(new Node(next, ii, jj));
                }
            }
            result++;
        }
        return -1;
    }

    private String toString(int[][] board) {
        return Arrays.toString(board[0]) + Arrays.toString(board[1]);
    }

    private int[][] swap(int[][] board, int i, int j, int ii, int jj) {
        int[][] result = new int[2][3];
        result[0] = Arrays.copyOf(board[0], board[0].length);
        result[1] = Arrays.copyOf(board[1], board[1].length);

        int tmp = result[i][j];
        result[i][j] = result[ii][jj];
        result[ii][jj] = tmp;
        return result;
    }

    class Node {
        int[][] board;
        int i, j; // position of "0";

        public Node(int[][] board, int i, int j) {
            this.board = board;
            this.i = i;
            this.j = j;
        }
    }

}
