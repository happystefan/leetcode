package google;

public class Q357_Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return countNumbersWithUniqueDigits(10);
        int[] ans = new int[1];
        boolean[] used = new boolean[10];
        for (int i = 1; i < 10; i++) {
            used[i] = true;
            dfs(n - 1, used, ans);
            used[i] = false;
        }
        return ans[0] + 1;
    }

    private void dfs(int n, boolean[] used, int[] ans) {
        ans[0] += 1;
        if (n == 0) return;
        for (int i = 0; i < 10; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(n - 1, used, ans);
            used[i] = false;
        }
    }

}
