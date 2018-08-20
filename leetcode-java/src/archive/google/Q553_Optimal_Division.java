package archive.google;

public class Q553_Optimal_Division {

    // Backtracking
    public String optimalDivision(int[] nums) {
        return dfs(nums, 0, nums.length-1).max_exp;
    }

    private Node dfs(int[] nums, int l, int r) {
        Node result = new Node();
        if (l == r) {
            result.max_exp = result.min_exp = String.valueOf(nums[l]);
            result.max_val = result.min_val = nums[l];
            return result;
        }
        for (int i = l; i < r; i++) {
            Node lpart = dfs(nums, l, i);
            Node rpart = dfs(nums, i+1, r);
            if (result.min_val > lpart.min_val / rpart.max_val) {
                result.min_val = lpart.min_val / rpart.max_val;
                result.min_exp = lpart.min_exp + "/" + (i+1 != r ? "(" : "") + rpart.max_exp + (i+1 != r ? ")" : "");
            }
            if (result.max_val < lpart.max_val / rpart.min_val) {
                result.max_val = lpart.max_val / rpart.min_val;
                result.max_exp = lpart.max_exp + "/" + (i+1 != r ? "(" : "") + rpart.min_exp + (i+1 != r ? ")" : "");
            }
        }
        return result;
    }

    class Node {
        String max_exp = "";
        String min_exp = "";
        double min_val = Integer.MAX_VALUE;
        double max_val = Integer.MIN_VALUE;
    }

}
