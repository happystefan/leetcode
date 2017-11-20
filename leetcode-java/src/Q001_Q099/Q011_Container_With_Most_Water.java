package Q001_Q099;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length-1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            ans = Math.max(ans, h*(r-l));
            while (l < r && height[l] <= h) l++;
            while (l < r && height[r] <= h) r--;
        }
        return ans;
    }
}
