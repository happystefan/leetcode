package archive.google;

import java.util.*;

public class Q353_Design_Snake_Game {

    class SnakeGame {

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

        int w;
        int h;
        int score;
        Set<Node> set = new HashSet<>();
        DQueue Q = new DQueue();
        int[][] food;
        int fidx;
        public SnakeGame(int width, int height, int[][] food) {
            this.w = width;
            this.h = height;
            this.score = 0;
            this.food = food;
            this.fidx = 0;
            Node node = new Node(0, 0);
            Q.insert(node);
            set.add(node);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            Node curr = Q.peekFirst();
            int i = curr.i, j = curr.j;
            switch (direction) {
                case "U": i--; break;
                case "D": i++; break;
                case "L": j--; break;
                case "R": j++; break;
            }
            Node node = new Node(i, j);
            set.remove(Q.peekLast());
            if (i < 0 || i >= h || j < 0 || j >= w || set.contains(node)) {
                return -1;
            }
            Q.insert(node);
            set.add(node);
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

    class Node {
        int i, j;
        Node prev;
        Node next;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            Node other = (Node)obj;
            return this.i == other.i && this.j == other.j;
        }

        @Override
        public int hashCode() {
            return (i+","+j).hashCode();
        }
    }

    class DQueue {
        Node head, tail; // head and tail are actually dummy nodes
        public DQueue() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        // insert a node to front
        public void insert(Node node) {
            Node next = head.next;
            next.prev = node;
            node.prev = head;
            node.next = next;
            head.next = node;
        }
        // poll the last node
        public void pollLast() {
            Node last = tail.prev;
            Node prev = last.prev;
            prev.next = tail;
            tail.prev = prev;
        }

        public Node peekFirst() {
            return head.next;
        }

        public Node peekLast() {
            return tail.prev;
        }
    }

}
