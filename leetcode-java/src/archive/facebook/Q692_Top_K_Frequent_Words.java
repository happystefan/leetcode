package archive.facebook;

import java.util.*;

public class Q692_Top_K_Frequent_Words {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq-b.freq);
        for (String word : map.keySet()) {
            Q.add(new Node(word, map.get(word)));
            if (Q.size() > k) Q.poll();
        }
        List<String> result = new LinkedList<>();
        while (!Q.isEmpty()) {
            result.add(0, Q.poll().word);
        }
        return result;
    }

    class Node {
        String word;
        int freq;
        public Node(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

}
