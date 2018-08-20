package archive.google;

import java.util.*;

public class Q336_Palindrome_Pairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int l = 0, r = 0;
            while (l <= r) {
                String padding = reverse(word.substring(l, r));
                String other = l == 0 ? word.substring(r) : word.substring(0, l);
                if (map.containsKey(padding) && map.get(padding) != i && isPalindrome(other)) {
                    if (l == 0) ans.add(Arrays.asList(i, map.get(padding)));
                    else ans.add(Arrays.asList(map.get(padding), i));
                }
                if (r < word.length()) r++;
                else l++;
            }
        }
        return ans;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

}
