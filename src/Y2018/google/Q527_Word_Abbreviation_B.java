package Y2018.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q527_Word_Abbreviation_B {

    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : dict) {
            String key = abbrev(word, 0);
            map.computeIfAbsent(key, k -> new LinkedList<>());
            map.get(key).add(word);
        }
        Map<String, String> memo = new HashMap<>();
        for (String abbr : map.keySet()) {
            List<String> group = map.get(abbr);
            if (group.size() == 1) {
                memo.put(group.get(0), abbr);
                continue;
            }
            /*
            Collections.archive.sort(group);
            int[] lcp = new int[group.size()];
            for (int i = 1; i < group.size(); ++i) {
                int p = longestCommonPrefix(group.get(i-1), group.get(i));
                lcp[i] = p;
                lcp[i-1] = Math.max(lcp[i-1], p);
            }
            for (int i = 0; i < group.size(); i++) {
                memo.put(group.get(i), abbrev(group.get(i), lcp[i]));
            }
            */
            TrieNode root = new TrieNode();
            for (String word : group) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    if (curr.next[c - 'a'] == null) {
                        curr.next[c - 'a'] = new TrieNode();
                    }
                    curr.cnt++;
                    curr = curr.next[c - 'a'];
                }
            }
            for (String word : group) {
                TrieNode curr = root;
                int i = 0;
                for (char c : word.toCharArray()) {
                    if (curr.cnt == 1) {
                        break;
                    }
                    curr = curr.next[c - 'a'];
                    i++;
                }
                memo.put(word, abbrev(word, i));
            }

        }

        List<String> result = new LinkedList<>();
        for (String word : dict) {
            result.add(memo.get(word));
        }
        return result;
    }

    private int longestCommonPrefix(String a, String b) {
        int i = 0;
        while (a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }

    private String abbrev(String word, int i) {
        int len = word.length();
        if (len - i <= 3) return word;
        return word.substring(0, i + 1) + (len - i - 2) + word.charAt(len - 1);
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int cnt;
    }

}
