package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q042_Word_Filter {

    interface WordFinder {
        void init(Set<String> words);

        Set<String> find(List<Character> characters);
    }

    class WordFinderImpl implements WordFinder {

        Node root = new Node();

        @Override
        public void init(Set<String> words) {
            for (String word : words) {
                add(root, 0, word);
            }
        }

        @Override
        public Set<String> find(List<Character> characters) {
            Set<String> rslt = new HashSet<>();
            find(rslt, root, characters, "");
            return rslt;
        }

        private void add(Node root, int i, String word) {
            if (i == word.length()) {
                root.isWord = true;
                return;
            }
            char c = word.charAt(i);
            root.children.computeIfAbsent(c, k -> new Node());
            add(root.children.get(c), i + 1, word);
        }

        private void find(Set<String> rslt, Node root, List<Character> chars, String str) {
            if (root.isWord) {
                rslt.add(str);
            }
            for (int i = 0; i < chars.size(); i++) {
                char c = chars.get(i);
                if (!root.children.containsKey(c)) continue;
                List<Character> charsNew = new LinkedList<>(chars);
                charsNew.remove(i);
                find(rslt, root.children.get(c), charsNew, str + c);
            }
        }
    }

    class Node {
        HashMap<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

}
