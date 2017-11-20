package Q100_Q199;

public class Q134_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, j;
        int n = gas.length;
        for (i = 0; i < n; i+=j) {
            int sum = 0;
            for (j = 1; j <= n; j++) {
                int k = (i+j-1)%n;
                sum += gas[k]-cost[k];
                if (sum < 0) break;
            }
            if (j > n) return i;
        }
        return -1;
    }

}
