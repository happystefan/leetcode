import java.util.LinkedList;
import java.util.List;

public class Q131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        partition(ans, new LinkedList<>(), s);
        return ans;
    }

    public void partition(List<List<String>> ans, List<String> list, String s) {
        if (isPalindrome(s)) {
            List<String> ll = new LinkedList<>(list);
            ll.add(s);
            ans.add(ll);
        }
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i), s2 = s.substring(i, s.length());
            if (isPalindrome(s1)) {
                List<String> nlist = new LinkedList<>(list);
                nlist.add(s1);
                partition(ans, nlist, s2);
            }
        }
    }

    public boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
