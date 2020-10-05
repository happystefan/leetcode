package Y2020.linkedin.algo_part1;

import java.util.LinkedList;
import java.util.List;

public class TODO_Q038_Multi_Dimension_Sum {

    class MultiDimArray {
        public int get(int[] indices) {
            return 0;
        }
    }

    class solution_iterative {
        public int sum(MultiDimArray m, int[] dimensions) {
            int k = 1;
            for (int d : dimensions) {
                k *= d;
            }
            int[] indices = new int[dimensions.length];
            int curr = dimensions.length - 1;
            int rslt = 0;
            while (k-- > 0) {
                indices[curr] += 1;
                if (indices[curr] == dimensions[curr]) {
                    indices[curr] = 0;
                    curr--;
                } else {
                    rslt += m.get(indices);
                }
            }
            return rslt;
        }
    }

    class solution_recursive {
        public int sum(MultiDimArray m, int[] dimensions) {
            return sum(m, dimensions, 0, new LinkedList<>());
        }

        private int sum(MultiDimArray m, int[] dimensions, int curr, List<Integer> list) {
            if (dimensions.length == list.size()) {
                int[] indices = list.stream().mapToInt(i -> i).toArray();
                return m.get(indices);
            }
            int sum = 0;
            for (int i = 0; i < dimensions[curr]; i++) {
                list.add(i);
                sum += sum(m, dimensions, curr + 1, list);
                list.remove(list.size() - 1);
            }
            return sum;
        }
    }

    public int allDiagonalSum(MultiDimArray m, int[] dimensions) {
        // TODO
        return 0;
    }
}
