package Y2018.facebook;

public class Q768_Max_Chunks_To_Make_Sorted_II {

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] lmax = new int[arr.length];
        lmax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        }
        int[] rmin = new int[arr.length];
        rmin[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (lmax[i] <= rmin[i + 1]) {
                result++;
            }
        }
        return result + 1;
    }

}
