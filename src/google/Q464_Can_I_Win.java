package google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q464_Can_I_Win {

    Map<String, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        return canWin(0, new int[maxChoosableInteger + 1], desiredTotal);
    }

    private boolean canWin(int sum, int[] visited, int desiredTotal) {
        if (sum >= desiredTotal) {
            return true;
        }
        String state = Arrays.toString(visited);
        if (map.containsKey(state)) {
            return map.get(state);
        }
        boolean result = false;
        for (int i = visited.length - 1; i >= 1; i--) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            if (sum + i >= desiredTotal || !canWin(sum + i, visited, desiredTotal)) {
                visited[i] = 0;
                result = true;
                break;
            }
            visited[i] = 0;
        }
        map.put(state, result);
        return result;
    }

}
