package Y2018.Q001_Q300;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) repeated.add(sub);
        }
        return new LinkedList<>(repeated);
    }

}
