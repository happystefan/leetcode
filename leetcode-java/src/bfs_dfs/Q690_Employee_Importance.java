package bfs_dfs;

import java.util.*;

public class Q690_Employee_Importance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        if (map.get(id).subordinates.size() == 0) {
            return map.get(id).importance;
        }
        int result = map.get(id).importance;
        for (int i : map.get(id).subordinates) {
            result += dfs(i);
        }
        return result;
    }

}
