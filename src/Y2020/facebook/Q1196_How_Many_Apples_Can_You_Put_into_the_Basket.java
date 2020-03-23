package Y2020.facebook;

import java.util.Arrays;

public class Q1196_How_Many_Apples_Can_You_Put_into_the_Basket {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int rslt = 0;
        int sum = 0;
        for (int w : arr) {
            sum += w;
            if (sum > 5000) break;
            rslt++;
        }
        return rslt;
    }

}
