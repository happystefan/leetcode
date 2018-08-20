package archive.dp;

public class Q418_Sentence_Screen_Fitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int senLen = 0;
        for (String word : sentence) {
            senLen += word.length() + 1;
        }
        int senCntPerRow = (cols+1)/senLen;

        int si = 0;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            result += senCntPerRow;
            int j = senCntPerRow*senLen;
            while ((j < cols) && (si < sentence.length) && (j+sentence[si].length()-1 < cols)) {
                j += sentence[si].length()+1;
                si++;
            }
            while (si >= sentence.length) {
                result++;
                si = 0;
                while ((j < cols) && (si < sentence.length) && (j+sentence[si].length()-1 < cols)) {
                    j += sentence[si].length()+1;
                    si++;
                }
            }
        }
        return result;
    }

}
