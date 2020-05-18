package Y2020.facebook.misc;

import java.util.HashSet;
import java.util.Set;

public class Q0489_Robot_Room_Cleaner {

    // This is the robot's control interface.
    // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(Robot robot, Set<String> visited, int i, int j, int cur_dir) {
        String cur_pos = i + "#" + j;
        if (visited.contains(cur_pos)) return;

        robot.clean();
        visited.add(cur_pos);

        for (int k = 0; k < 4; k++) {
            int new_dir = (cur_dir + k) % 4;
            int ii = i + dirs[new_dir][0], jj = j + dirs[new_dir][1];
            String new_pos = ii + "#" + jj;
            if (!visited.contains(new_pos) && robot.move()) {
                dfs(robot, visited, ii, jj, new_dir);
                { // go back
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
            }
            robot.turnRight();
        }
    }

}
