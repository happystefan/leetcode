package Y2019.misc;

public class Q0011_Heap {

    class MinHeap {
        int[] nums;
        int idx = 0;

        public MinHeap(int size) {
            nums = new int[size + 1];
        }

        public MinHeap(int[] nums) {
            this.nums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                this.nums[i + 1] = nums[i];
            }
            idx = nums.length;
            for (int i = idx / 2; i > 0; i--) {
                pushDown(i);
            }
        }

        public void insert(int n) {
            int i = ++idx;
            while (nums[i / 2] > n) {
                nums[i] = nums[i / 2];
                i /= 2;
            }
            nums[i] = n;
        }

        public int pop() {
            int result = nums[1];
            nums[1] = nums[idx--];
            pushDown(1);
            return result;
        }

        private void pushDown(int i) {
            int tmp = nums[i];
            while (i * 2 <= idx) {
                int child = i * 2;
                if (child != idx && nums[child + 1] < nums[child]) child++;
                if (nums[child] < tmp) nums[i] = nums[child];
                else break;
                i = child;
            }
            nums[i] = tmp;
        }

    }

}
