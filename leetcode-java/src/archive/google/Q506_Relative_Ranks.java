package archive.google;

import java.util.PriorityQueue;

public class Q506_Relative_Ranks {

    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer[]> pqueue = new PriorityQueue<>((a, b) -> b[1]-a[1]);
        for (int i = 0; i < nums.length; i++) pqueue.add(new Integer[]{i, nums[i]});

        String[] ans = new String[nums.length];
        if (!pqueue.isEmpty()) ans[pqueue.poll()[0]] = "Gold Medal";
        if (!pqueue.isEmpty()) ans[pqueue.poll()[0]] = "Silver Medal";
        if (!pqueue.isEmpty()) ans[pqueue.poll()[0]] = "Bronze Medal";
        int cnt = 4;
        while (!pqueue.isEmpty()) ans[pqueue.poll()[0]] = String.format("%d", cnt++);
        return ans;
    }

}
