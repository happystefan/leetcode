package Y2018.facebook.sliding_window;

public class Q011_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return result;
    }

}
