package Q001_Q300;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q256_Paint_House {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int len = costs.length-1;
        return Math.min(costs[len][0], Math.min(costs[len][1], costs[len][2]));
    }

}
