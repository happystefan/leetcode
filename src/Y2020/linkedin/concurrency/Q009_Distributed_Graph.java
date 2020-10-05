package Y2020.linkedin.concurrency;

import java.util.Arrays;

public class Q009_Distributed_Graph {

    interface Graph {
        int[] getConnections(int memID);
    }

    class DisGraph implements Graph {

        public int[] getConnections(int memID) {
            return new int[]{};
        }

        public boolean isZeroDegreeConn(int src, int dst) {
            return src == dst;
        }

        public boolean isFirstDegreeConn(int src, int dst) {
            int[] conns = getConnections(src);
            return Arrays.binarySearch(conns, dst) >= 0;
        }

        public boolean isSecondDegreeConn(int src, int dst) {
            int[] srcConns = getConnections(src);
            int[] dstConns = getConnections(dst);
            return hasInterSections(srcConns, dstConns);
        }

        private boolean hasInterSections(int[] srcConns, int[] dstConns) {
            int i = 0, j = 0;
            while (i < srcConns.length && j < dstConns.length) {
                if (srcConns[i] == dstConns[j]) return true;
                if (srcConns[i] < dstConns[j]) i++;
                else j++;
            }
            return false;
        }

        public boolean isThirdDegreeConn(int src, int dst) {
            int[] srcConns = getConnections(src);
            int[] dstConns = getConnections(dst);
            for (int i = 0; i < srcConns.length; i++) {
                if (hasInterSections(getConnections(srcConns[i]), dstConns)) return true;
            }
            return false;
        }
    }

}
