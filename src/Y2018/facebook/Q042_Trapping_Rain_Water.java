package Y2018.facebook;

public class Q042_Trapping_Rain_Water {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int result = 0;
        while (l <= r) {
            if (height[l] < height[r]) {
                if (height[l] > lmax) lmax = height[l];
                else result += lmax - height[l];
                l++;
            } else {
                if (height[r] > rmax) rmax = height[r];
                else result += rmax - height[r];
                r--;
            }
        }
        return result;
    }

}
