package Y2018.facebook;

public class Q423_Reconstruct_Original_Digits_from_English {

    public String originalDigits(String s) {
        String[] table = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'z':
                    cnt[0]++;
                    break;
                case 'w':
                    cnt[2]++;
                    break;
                case 'x':
                    cnt[6]++;
                    break;
                case 's':  // 6, 7
                    cnt[7]++;
                    break;
                case 'g':
                    cnt[8]++;
                    break;
                case 'u':
                    cnt[4]++;
                    break;
                case 'f':  // 4, 5
                    cnt[5]++;
                    break;
                case 'h':  // 3, 8
                    cnt[3]++;
                    break;
                case 'i':   // 5, 6, 8, 9
                    cnt[9]++;
                    break;
                case 'o':   // 0, 1, 2, 4
                    cnt[1]++;
                    break;
            }
        }
        cnt[7] -= cnt[6];
        cnt[5] -= cnt[4];
        cnt[3] -= cnt[8];
        cnt[9] -= (cnt[5] + cnt[6] + cnt[8]);
        cnt[1] -= (cnt[0] + cnt[2] + cnt[4]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (cnt[i]-- > 0) sb.append(i);
        }
        return sb.toString();
    }

}
