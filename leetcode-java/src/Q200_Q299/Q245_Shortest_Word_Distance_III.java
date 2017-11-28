package Q200_Q299;

public class Q245_Shortest_Word_Distance_III {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    p1 = p2;
                }
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                ans = Math.min(ans, Math.abs(p1-p2));
            }
        }
        return ans;
    }

}
