package graph;

import java.util.*;

public class Q841_Keys_and_Rooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            visited.add(i);
        }
        dfs(rooms, 0, visited);
        return visited.isEmpty();
    }

    private void dfs(List<List<Integer>> rooms, int pos, Set<Integer> visited) {
        visited.remove(pos);
        List<Integer> next_rooms = rooms.get(pos);
        for (int i : next_rooms) {
            if (!visited.contains(i)) {
                continue;
            }
            dfs(rooms, i, visited);
        }
    }

}
