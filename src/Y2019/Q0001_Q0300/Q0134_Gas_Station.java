package Y2019.Q0001_Q0300;

public class Q0134_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, pos = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                pos = i + 1;
            }
        }
        return total < 0 ? -1 : pos;
    }

}
