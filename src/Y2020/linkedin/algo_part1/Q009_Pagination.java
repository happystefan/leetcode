package Y2020.linkedin.algo_part1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q009_Pagination {

    public List<String> Paginate(String text, int pageLen) {
        List<String> words = Arrays.asList(text.split("\\s"));
        Iterator<String> wordIt = words.iterator();
        List<String> page = new LinkedList<>();
        List<String> rslt = new LinkedList<>();
        int currPageLen = 0;
        while (wordIt.hasNext()) {
            String word = wordIt.next();
            if (currPageLen + word.length() + 1 <= pageLen) {
                page.add(word);
                currPageLen += word.length() + 1;
            } else {
                rslt.add(padding(page));
                page.clear();
                page.add(word);
                currPageLen = word.length();
            }
        }
        if (!page.isEmpty()) {
            rslt.add(padding(page));
        }
        return rslt;
    }

    private String padding(List<String> page) {
        return String.join(" ", page);
    }

}
