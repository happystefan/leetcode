package Y2020.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q1306_Jump_Game_III {

    class solution_bfs {

        public boolean canReach(int[] arr, int start) {
            if (arr == null || arr.length == 0 || start >= arr.length) return false;
            if (arr[start] == 0) return true;
            Queue<Integer> Q = new LinkedList<>();
            Q.add(start);
            boolean[] visited = new boolean[arr.length];
            while (!Q.isEmpty()) {
                int curr = Q.poll();
                if (arr[curr] == 0) return true;
                if (visited[curr]) continue;
                visited[curr] = true;
                int l = curr - arr[curr];
                int r = curr + arr[curr];
                if (l >= 0 && l < arr.length && !visited[l]) Q.add(l);
                if (r >= 0 && r < arr.length && !visited[r]) Q.add(r);
            }
            return false;
        }

    }

    class solution_recursive {

        public boolean canReach(int[] arr, int start) {
            if (arr == null || arr.length == 0 || start >= arr.length) return false;
            if (arr[start] == 0) return true;
            return jump(arr, start, new boolean[arr.length]);
        }

        private boolean jump(int[] nums, int pos, boolean[] visited) {
            if (pos < 0 || pos >= nums.length) return false;
            if (visited[pos]) return false;
            if (nums[pos] == 0) return true;
            visited[pos] = true;
            int l = pos - nums[pos];
            int r = pos + nums[pos];
            return jump(nums, l, visited) || jump(nums, r, visited);
        }

    }

}
