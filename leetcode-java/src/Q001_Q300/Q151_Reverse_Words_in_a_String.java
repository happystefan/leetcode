package Q001_Q300;

public class Q151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        String ans = "";
        for (String word : words) {
            if (word.equals("")) continue;
            ans = word + " " + ans;
        }
        return ans.trim();
    }

}
