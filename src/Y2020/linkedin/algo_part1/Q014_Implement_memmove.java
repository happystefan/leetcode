package Y2020.linkedin.algo_part1;

public class Q014_Implement_memmove {

    public void memmove(char[] arr, int src, int dst, int size) {
        if (src == dst) return;
        if (src < dst) {
            int j = dst + size - 1;
            int i = src + size - 1;
            if (j >= arr.length) {
                int diff = j - (arr.length - 1);
                j -= diff;
                i -= diff;
            }
            while (j >= dst) {
                arr[j--] = arr[i--];
            }
        } else { // src > dst
            int i = src;
            int j = dst;
            while (j < dst + size && j < arr.length) {
                arr[j++] = arr[i++];
            }

        }
    }
}
