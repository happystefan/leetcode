package facebook;

import java.util.*;

public class Q336_Palindrome_Pairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int l = 0, r = 0;
            while (l <= r) {
                String padding = reverse(word.substring(l, r));
                String other = l == 0 ? word.substring(r) : word.substring(0, l);
                if (map.containsKey(padding) && isPalindrome(other) && map.get(padding) != i) {
                    if (l == 0) {
                        result.add(Arrays.asList(i, map.get(padding)));
                    } else {
                        result.add(Arrays.asList(map.get(padding), i));
                    }
                }
                if (r < word.length()) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
