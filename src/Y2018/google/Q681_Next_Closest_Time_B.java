package Y2018.google;

public class Q681_Next_Closest_Time_B {

    public String nextClosestTime(String time) {
        String[] s = time.split(":");
        int h = Integer.valueOf(s[0]), m = Integer.valueOf(s[1]);
        String t = "";
        do {
            m++;
            if (m == 60) {
                h++;
                m = 0;
            }
            if (h == 24) h = 0;
            t = String.format("%02d:%02d", h, m);
        } while (!isValid(t, time));
        return t;
    }

    private boolean isValid(String t, String s) {
        for (char c : t.toCharArray()) {
            if (!s.contains(c + "")) return false;
        }
        return true;
    }

}
