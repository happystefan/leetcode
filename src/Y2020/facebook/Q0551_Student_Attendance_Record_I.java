package Y2020.facebook;

public class Q0551_Student_Attendance_Record_I {

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;
        char[] ss = s.toCharArray();
        int absent = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == 'A') absent++;
            if (absent > 1) return false;
        }
        return !s.contains("LLL");
    }

}
