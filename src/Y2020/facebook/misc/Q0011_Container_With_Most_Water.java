package Y2020.facebook.misc;

public class Q0011_Container_With_Most_Water {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int rslt = 0;
        while (l < r) {
            rslt = Math.max(rslt, Math.min(height[l], height[r]) * (r - 1));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return rslt;
    }

}
