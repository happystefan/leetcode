package google;

public class Q459_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            if (s.length()%i != 0) continue;
            String sub = s.substring(0, i);
            //if (s.split(sub).length == 0) return true;
            if (s.replaceAll(sub, "").equals("")) return true;
        }
        return false;
    }

}
