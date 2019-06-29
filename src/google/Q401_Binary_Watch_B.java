package google;

import java.util.LinkedList;
import java.util.List;

public class Q401_Binary_Watch_B {

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    ans.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return ans;
    }

}
