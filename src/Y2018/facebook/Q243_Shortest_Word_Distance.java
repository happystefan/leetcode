package Y2018.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q243_Shortest_Word_Distance {

    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) index1.add(i);
            if (words[i].equals(word2)) index2.add(i);
        }
        int result = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while (p1 != index1.size() && p2 != index2.size()) {
            result = Math.min(result, Math.abs(index1.get(p1) - index2.get(p2)));
            if (index1.get(p1) < index2.get(p2)) p1++;
            else p2++;
        }
        return result;
    }

}
