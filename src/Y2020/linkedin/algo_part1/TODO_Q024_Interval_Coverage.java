package Y2020.linkedin.algo_part1;

import java.util.*;

public class TODO_Q024_Interval_Coverage {

    // log(N) when add(),O(N) when getCovered()
    // !!! This solution if there are adjacent intervals: [1, 4], [4, 5];
    class solution implements Intervals {

        TreeMap<Integer, Boolean> map = new TreeMap<>();
        @Override
        public void addInterval(int from, int to) {
            map.put(from, true);
            map.put(to, false);
        }

        @Override
        public int getTotalCoveredLength() {
            int rslt = 0;
            int open = 0; // open intervals;
            int from = 0;
            for (int coordinate : map.keySet()) {
                boolean isStart = map.get(coordinate);
                open += isStart ? 1 : -1;
                if (isStart && open == 1) {
                    from = coordinate;
                }
                if (!isStart && open == 0) {
                    rslt += coordinate - from;
                }
            }
            return rslt;
        }
    }


    // O(1) when add(),O(N*logN) when getCovered()
    class solution_merge_when_add implements Intervals {

        List<int[]> itvs = new ArrayList<>();
        @Override
        public void addInterval(int from, int to) {
            itvs.add(new int[]{from, to});
        }

        @Override
        public int getTotalCoveredLength() {
            Collections.sort(itvs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int rslt = 0;
            for (int i = 0; i < itvs.size(); i++) {
                int start = itvs.get(i)[0];
                int end = itvs.get(i)[1];
                while (i + 1 < itvs.size() && itvs.get(i+1)[0] <= end) {
                    end = Math.max(end, itvs.get(i+1)[1]);
                    i++;
                }
                rslt += end - start;
            }
            return rslt;
        }
    }

    interface Intervals {
        void addInterval(int from, int to);
        int getTotalCoveredLength();
    }
}
