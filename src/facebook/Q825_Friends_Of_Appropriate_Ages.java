package facebook;

public class Q825_Friends_Of_Appropriate_Ages {

    // B in : (0.5*A+7, A]
    public int numFriendRequests(int[] ages) {
        int[] cnts = new int[121];
        int[] sums = new int[122];
        for (int age : ages) {
            cnts[age]++;
        }
        for (int i = 1; i < cnts.length; i++) {
            sums[i] = sums[i - 1] + cnts[i];
        }
        int result = 0;
        for (int i = 15; i <= 120; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            int count = sums[i] - sums[i / 2 + 7];
            result += count * cnts[i] - cnts[i];
        }
        return result;
    }

}
