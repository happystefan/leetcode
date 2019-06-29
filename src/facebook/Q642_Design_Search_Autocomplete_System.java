package facebook;

import java.util.*;

public class Q642_Design_Search_Autocomplete_System {

    class AutocompleteSystem {
        TrieNode root = new TrieNode();
        String prefix = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                int cnt = times[i];
                add(sentences[i], times[i]);
            }
        }

        private void add(String sentence, int cnt) {
            TrieNode curr = root;
            for (char c : sentence.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.count.put(sentence, curr.count.getOrDefault(sentence, 0) + cnt);
            }
            //curr.sentence = sentence;
        }

        public List<String> input(char c) {
            if (c == '#') {
                add(prefix, 1);
                prefix = "";
                return new ArrayList<>();
            }
            prefix += c;

            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }

            PriorityQueue<Pair> Q = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
            for (String s : curr.count.keySet()) {
                Q.add(new Pair(s, curr.count.get(s)));
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < 3 && !Q.isEmpty(); i++) {
                result.add(Q.poll().s);
            }
            return result;
        }
    }

    class Pair {
        String s;
        int c;

        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        //String sentence;
    }


    /*
     * Your AutocompleteSystem object will be instantiated and called as such:
     * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
     * List<String> param_1 = obj.input(c);
     */

}
