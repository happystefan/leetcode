package google;

import java.util.ArrayList;
import java.util.List;

public class Q081_Data_Stream_Median {

    public int[] medianII(int[] nums) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = list.size()-1;
            while (l <= r) {
                int m = (l+r)/2;
                if (list.get(m) < nums[i]) l = m+1;
                else r = m-1;
            }
            list.add(l, nums[i]);
            ans[k++] = list.get(i/2);
        }
        return ans;
    }

}
