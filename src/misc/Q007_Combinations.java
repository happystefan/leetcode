package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q007_Combinations {

    class Q077_Combinations {
        /*
        ----------------------------------------------------------------------------------------------------------------
        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        Example:
            Input: n = 4, k = 2
            Output:
            [
              [2,4],
              [3,4],
              [2,3],
              [1,2],
              [1,3],
              [1,4],
            ]
        ----------------------------------------------------------------------------------------------------------------
        */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new LinkedList<>();
            dfs(result, new LinkedList<>(), n, 1, k);
            return result;
        }

        private void dfs(List<List<Integer>> result, List<Integer> list, int n, int pos, int k) {
            if (list.size() == k) {
                result.add(new LinkedList<>(list));
                return;
            }
            if (list.size() > k || pos > n) {
                return;
            }
            for (int i = pos; i <= n; i++) {
                list.add(i);
                dfs(result, list, n, i + 1, k);
                list.remove(list.size() - 1);
            }
        }
    }

    class Q039_Combination_Sum {
        /*
        ----------------------------------------------------------------------------------------------------------------
        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
        find all unique combinations in candidates where the candidate numbers sums to target.

        The same repeated number may be chosen from candidates unlimited number of times.

        Note:
            * All numbers (including target) will be positive integers.
            * The solution set must not contain duplicate combinations.

        Example 1:
            Input: candidates = [2,3,6,7], target = 7,
            A solution set is:
            [
                [7],
                [2,2,3]
            ]

        Example 2:
            Input: candidates = [2,3,5], target = 8,
            A solution set is:
            [
                [2,2,2,2],
                [2,3,3],
                [3,5]
            ]
        ----------------------------------------------------------------------------------------------------------------
        */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new LinkedList<>();
            Arrays.sort(candidates);
            dfs(result, new LinkedList<>(), candidates, 0, target);
            return result;
        }

        private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int target) {
            if (target == 0) {
                result.add(new LinkedList<>(list));
            }
            if (target < 0) {
                return;
            }
            for (int i = pos; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(result, list, nums, i, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    class Q040_Combination_Sum_II {
        /*
        ----------------------------------------------------------------------------------------------------------------
        Given a collection of candidate numbers (candidates) and a target number (target),
        find all unique combinations in candidates where the candidate numbers sums to target.

        Each number in candidates may only be used once in the combination.

        Note:
            * All numbers (including target) will be positive integers.
            * The solution set must not contain duplicate combinations.

        Example 1:
            Input: candidates = [10,1,2,7,6,1,5], target = 8,
            A solution set is:
            [
              [1, 7],
              [1, 2, 5],
              [2, 6],
              [1, 1, 6]
            ]

        Example 2:
            Input: candidates = [2,5,2,1,2], target = 5,
            A solution set is:
            [
              [1,2,2],
              [5]
            ]
        ----------------------------------------------------------------------------------------------------------------
        */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new LinkedList<>();
            dfs(result, new LinkedList<>(), candidates, 0, target);
            return result;
        }

        private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int pos, int target) {
            if (target == 0) {
                result.add(new LinkedList<>(list));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = pos; i < nums.length; i++) {
                if (i > pos && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                dfs(result, list, nums, i + 1, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }

    }

    class Q216_Combination_Sum_III {
        /*
        ----------------------------------------------------------------------------------------------------------------
        Find all possible combinations of k numbers that add up to a number n,
        given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

        Note:
            * All numbers will be positive integers.
            * The solution set must not contain duplicate combinations.

        Example 1:
            Input: k = 3, n = 7
            Output: [[1,2,4]]

        Example 2:
            Input: k = 3, n = 9
            Output: [[1,2,6], [1,3,5], [2,3,4]]
        ----------------------------------------------------------------------------------------------------------------
        */
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new LinkedList<>();
            dfs(result, new LinkedList<>(), 1, k, n);
            return result;
        }

        private void dfs(List<List<Integer>> result, List<Integer> list, int pos, int k, int target) {
            if (list.size() == k && target == 0) {
                result.add(new LinkedList<>(list));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = pos; i <= 9; i++) {
                list.add(i);
                dfs(result, list, i + 1, k, target - i);
                list.remove(list.size() - 1);
            }
        }
    }

    class Q377_Combination_Sum_IV {
        /*
        ----------------------------------------------------------------------------------------------------------------
        Given an integer array with all positive numbers and no duplicates,
        find the number of possible combinations that add up to a positive integer target.

        Example:
            nums = [1, 2, 3]
            target = 4

            The possible combination ways are:
                (1, 1, 1, 1)
                (1, 1, 2)
                (1, 2, 1)
                (1, 3)
                (2, 1, 1)
                (2, 2)
                (3, 1)

        Note that different sequences are counted as different combinations.
        Therefore the output is 7.

        Follow up:
            * What if negative numbers are allowed in the given array?
            * How does it change the problem?
            * What limitation we need to add to the question to allow negative numbers?
        ----------------------------------------------------------------------------------------------------------------
        */
        // DFS: Time Limit Exceeded
        public int combinationSum4_DFS(int[] nums, int target) {
            int[] result = new int[1];
            dfs(result, nums, target);
            return result[0];
        }

        private void dfs(int[] result, int[] nums, int target) {
            if (target == 0) {
                result[0] += 1;
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                dfs(result, nums, target - nums[i]);
            }
        }

        //--------------------------------------------------------------------------------------------------------------
        public int combinationSum4_DFS_MEMO(int[] nums, int target) {
            Integer[] memo = new Integer[target + 1];
            return dfs(nums, target, memo);
        }

        private int dfs(int[] nums, int target, Integer[] memo) {
            if (target == 0) {
                return 1;
            }
            if (target < 0) {
                return 0;
            }
            if (memo[target] != null) {
                return memo[target];
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result += dfs(nums, target - nums[i], memo);
            }
            memo[target] = result;
            return result;
        }

        //--------------------------------------------------------------------------------------------------------------
        public int combinationSum4_DP(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i <= target; i++) {
                for (int num : nums) {
                    if (i + num <= target) {
                        dp[i + num] += dp[i];
                    }
                }
            }
            return dp[target];
        }

    }

}
