package Y2018.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q045_Jump_Game_II {

    // BFS: Time Limit Exceeded
    public int jump(int[] nums) {
        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Q.offer(0);
        visited.add(0);
        int result = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                int pos = Q.poll();
                if (pos == nums.length - 1) {
                    return result;
                }
                for (int i = 1; i <= nums[pos] && pos + i < nums.length; i++) {
                    if (!visited.contains(pos + i)) {
                        Q.offer(pos + i);
                        visited.add(pos + i);
                    }
                }
            }
            result++;
        }
        return result;
    }

}

