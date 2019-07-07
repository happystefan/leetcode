package Y2019.Q0001_Q0300;

public class Q0011_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l < r) {
            result = Math.max(result, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return result;
    }

}
