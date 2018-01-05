package google;

public class Q681_Next_Closest_Time {

    public String nextClosestTime(String time) {
        int[] t = new int[]{Integer.valueOf(time.substring(0, 2)), Integer.valueOf(time.substring(3))};
        String ans = "";
        do {
            next(t);
            ans = String.format("%02d:%02d", t[0], t[1]);
        } while (!isValid(ans, time));
        return ans;
    }

    private boolean isValid(String t, String s) {
        for (char c : t.toCharArray())
            if (s.indexOf(c) == -1) return false;
        return true;
    }

    private void next(int[] t) {
        t[1]++;
        if (t[1] == 60) {
            t[0]++;
            t[1] = 0;
            if (t[0] == 24) t[0] = 0;
        }
    }

}
