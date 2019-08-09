package Y2019.misc.concurrent.mergesort;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.Executors;


public class Q001_Merge_Sort {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * Single Thread Merge Sort
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    static class SingleThreadMergeSort implements MergeSort {

        public void sort(int[] nums) {
            if (nums == null || nums.length == 0) return;
            mergeSort(nums, 0, nums.length - 1);
        }

        private void mergeSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int m = l + (r - l) / 2;

            /*
             *----------------------------------------------------------------------------------------------------------
             *
             * ATTENTION:
             * ```
             *      int[] lnums = Arrays.copyOfRange(nums, l, m);
             *      int[] rnums = Arrays.copyOfRange(nums, m, r + 1);
             * ```
             * Above code is WRONG: infinite loop.
             *
             *----------------------------------------------------------------------------------------------------------
             */
            int[] lnums = Arrays.copyOfRange(nums, l, m + 1);
            int[] rnums = Arrays.copyOfRange(nums, m + 1, r + 1);
            sort(lnums);
            sort(rnums);
            merge(nums, lnums, rnums, l);
        }

        private void merge(int[] nums, int[] lnums, int[] rnums, int k) {
            int i = 0, j = 0;
            while (i < lnums.length || j < rnums.length) {
                if (i == lnums.length) nums[k++] = rnums[j++];
                else if (j == rnums.length) nums[k++] = lnums[i++];
                else if (lnums[i] < rnums[j]) nums[k++] = lnums[i++];
                else nums[k++] = rnums[j++];
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * Simple Multiple Thread Merge Sort
     *
     * Problem: thrashing -- unlimited threads
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    static class MultiThreadMergeSort implements MergeSort {

        public void sort(int[] nums) {
            if (nums == null || nums.length == 0) return;
            mergeSort(nums, 0, nums.length - 1);
        }

        private void mergeSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int m = l + (r - l) / 2;

            int[] lnums = Arrays.copyOfRange(nums, l, m + 1);
            int[] rnums = Arrays.copyOfRange(nums, m + 1, r + 1);

            CountDownLatch latch = new CountDownLatch(2);

            new Thread(() -> {
                sort(lnums);
                latch.countDown();
            }).start();

            new Thread(() -> {
                sort(rnums);
                latch.countDown();
            }).start();

            try {
                latch.await();
            } catch (Exception e) {
                System.exit(0);
            }

            merge(nums, lnums, rnums, l);
        }

        private void merge(int[] nums, int[] lnums, int[] rnums, int k) {
            int i = 0, j = 0;
            while (i < lnums.length || j < rnums.length) {
                if (i == lnums.length) nums[k++] = rnums[j++];
                else if (j == rnums.length) nums[k++] = lnums[i++];
                else if (lnums[i] < rnums[j]) nums[k++] = lnums[i++];
                else nums[k++] = rnums[j++];
            }
        }

    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * Simple Multiple Thread Merge Sort with ForkJoinPool
     *
     *------------------------------------------------------------------------------------------------------------------
     */

    static class ForkJoinPoolMergeSort implements MergeSort {

        public void sort(int[] nums) {
            if (nums == null || nums.length == 0) return;
            ForkJoinPool pool = new ForkJoinPool(2);
            pool.submit(new SortThread(nums, 0, nums.length - 1)).join();
        }

        class SortThread extends RecursiveAction {
            int[] nums;
            int l;
            int r;

            private SortThread(int[] nums, int l, int r) {
                this.nums = nums;
                this.l = l;
                this.r = r;
            }

            @Override
            protected void compute() {
                if (l >= r) return;
                int m = l + (r - l) / 2;
                invokeAll(new SortThread(nums, l, m), new SortThread(nums, m + 1, r));
                merge(nums, l, r);
            }

            private void merge(int[] nums, int l, int r) {
                int m = l + (r - l) / 2;
                int[] lnums = Arrays.copyOfRange(nums, l, m + 1);
                int[] rnums = Arrays.copyOfRange(nums, m + 1, r + 1);
                int i = 0, j = 0, k = l;
                while (i < lnums.length || j < rnums.length) {
                    if (i == lnums.length) nums[k++] = rnums[j++];
                    else if (j == rnums.length) nums[k++] = lnums[i++];
                    else if (lnums[i] < rnums[j]) nums[k++] = lnums[i++];
                    else nums[k++] = rnums[j++];
                }
            }
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * Custom Work Queue
     *
     *------------------------------------------------------------------------------------------------------------------
     */

    static class WorkQueueMergeSort implements MergeSort {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<List<SortTask>> allTasks = new ArrayList<>();

        public void sort(int[] nums) {
            if (nums == null || nums.length == 0) return;
            allTasks.add(Arrays.asList(new SortTask(nums, 0, nums.length - 1)));

            while (!allTasks.get(allTasks.size() - 1).isEmpty()) {

                List<SortTask> list = allTasks.get(allTasks.size() - 1);
                List<SortTask> newList = new ArrayList<>();

                for (SortTask task : list) {
                    if (task.l >= task.r) continue;
                    int m = task.l + (task.r - task.l) / 2;
                    newList.add(new SortTask(nums, task.l, m));
                    newList.add(new SortTask(nums, m + 1, task.r));
                }
                allTasks.add(newList);
            }

            Collections.reverse(allTasks);

            for (List<SortTask> levelTasks : allTasks) {
                for (SortTask task : levelTasks) {
                    pool.execute(() -> task.run());
                }
            }

            pool.shutdown();
            try {
                pool.awaitTermination(10, TimeUnit.SECONDS);
            } catch (Exception e) {
            }

        }


        class SortTask {
            int[] nums;
            int l;
            int r;

            public SortTask(int[] nums, int l, int r) {
                this.nums = nums;
                this.l = l;
                this.r = r;
            }

            public void run() {
                merge(nums, l, r);
            }
        }


        private void merge(int[] nums, int l, int r) {
            int m = l + (r - l) / 2;
            int[] lnums = Arrays.copyOfRange(nums, l, m + 1);
            int[] rnums = Arrays.copyOfRange(nums, m + 1, r + 1);
            int i = 0, j = 0, k = l;
            while (i < lnums.length || j < rnums.length) {
                if (i == lnums.length) nums[k++] = rnums[j++];
                else if (j == rnums.length) nums[k++] = lnums[i++];
                else if (lnums[i] < rnums[j]) nums[k++] = lnums[i++];
                else nums[k++] = rnums[j++];
            }
        }
    }

}
