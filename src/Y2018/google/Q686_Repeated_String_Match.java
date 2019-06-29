package Y2018.google;

public class Q686_Repeated_String_Match {

    public int repeatedStringMatch(String A, String B) {
        int i = 1;
        String AA = A;
        while (!AA.contains(B)) {
            AA += A;
            i++;
            if (i > B.length() / A.length() + 2) return -1;
        }
        return i;
    }

}
