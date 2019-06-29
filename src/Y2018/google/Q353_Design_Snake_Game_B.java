package Y2018.google;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Q353_Design_Snake_Game_B {

    class SnakeGame {

        /**
         * Initialize your data structure here.
         *
         * @param width - screen width
         * @param height - screen height
         * @param food - A list of food positions
         * E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        int w;
        int h;
        int score;
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int[][] food;
        int fidx;

        public SnakeGame(int width, int height, int[][] food) {
            this.w = width;
            this.h = height;
            this.score = 0;
            this.food = food;
            this.fidx = 0;
            Q.addLast(0);
            set.add(0);
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            int i = Q.peekFirst() / w, j = Q.peekFirst() % w;
            switch (direction) {
                case "U":
                    i--;
                    break;
                case "D":
                    i++;
                    break;
                case "L":
                    j--;
                    break;
                case "R":
                    j++;
                    break;
            }
            set.remove(Q.peekLast());
            if (i < 0 || i >= h || j < 0 || j >= w || set.contains(i * w + j)) {
                return -1;
            }
            Q.addFirst(i * w + j);
            set.add(i * w + j);
            if (fidx < food.length && i == food[fidx][0] && j == food[fidx][1]) {
                set.add(Q.peekLast());
                score++;
                fidx++;
                return score;
            }
            Q.pollLast();
            return score;
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

}
