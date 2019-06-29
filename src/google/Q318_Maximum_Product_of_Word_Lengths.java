package google;

public class Q318_Maximum_Product_of_Word_Lengths {

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] bitmap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                bitmap[i] |= (1 << c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitmap[i] & bitmap[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

}
