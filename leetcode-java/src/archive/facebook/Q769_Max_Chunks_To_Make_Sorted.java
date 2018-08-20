package archive.facebook;

public class Q769_Max_Chunks_To_Make_Sorted {

    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                result++;
            }
        }
        return result;
    }

}
