package google;

public class Q888_Valid_Word_Square {

    public boolean validWordSquare(String[] words) {
        // Write your code here
        char[][] f = new char[500][500];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                f[i][j] = word.charAt(j);
            }
        }
        for (int i = 0; i < 500; i++) {
            for (int j = i+1; j < 500; j++) {
                if (f[i][j] != f[j][i]) return false;
            }
        }
        return true;
    }

}
