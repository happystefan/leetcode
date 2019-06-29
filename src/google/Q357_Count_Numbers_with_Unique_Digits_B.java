package google;

public class Q357_Count_Numbers_with_Unique_Digits_B {

    public int countNumbersWithUniqueDigits(int n) {
        boolean[] used = new boolean[10];
        return dfs(n > 10 ? 10 : n, used, true);
    }

    private int dfs(int n, boolean[] used, boolean firstCall) {
        if (n == 0) return 1;
        int cnt = 1;
        for (int i = (firstCall ? 1 : 0); i < 10; i++) {
            if (used[i]) continue;
            used[i] = true;
            cnt += dfs(n - 1, used, false);
            used[i] = false;
        }
        return cnt;
    }

}
