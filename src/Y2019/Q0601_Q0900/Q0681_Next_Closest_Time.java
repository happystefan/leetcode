package Y2019.Q0601_Q0900;

import java.util.*;

public class Q0681_Next_Closest_Time {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: next time
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public String nextClosestTime(String time) {
        int hh = Integer.valueOf(time.substring(0, 2));
        int mm = Integer.valueOf(time.substring(3));
        String tt = "";
        do {
            mm++;
            if (mm == 60) {
                mm = 0;
                hh++;
            }
            if (hh == 24) hh = 0;
            tt = String.format("%02d%02d", hh, mm);
        } while (isValid(tt, time));
        return tt;
    }

    private boolean isValid(String tt, String time) {
        for (char c : tt.toCharArray()) {
            if (!time.contains(c + "")) return false;
        }
        return true;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: permutation
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public String nextClosestTime_permutation(String time) {
        Set<Integer> digits = new HashSet(Arrays.asList(
                time.charAt(0) - '0',
                time.charAt(1) - '0',
                time.charAt(3) - '0',
                time.charAt(4) - '0'
        ));
        List<Integer> nums = new LinkedList<>();
        dfs(nums, 0, 0, digits);
        nums.removeIf(num -> {
            int hh = num / 100;
            int mm = num % 100;
            if (hh >= 24) return true;
            if (mm >= 60) return true;
            return false;
        });
        int result = nums.get(0);
        int min_diff = Integer.MAX_VALUE;
        int hh0 = Integer.valueOf(time.substring(0, 2));
        int mm0 = Integer.valueOf(time.substring(3));
        for (int num : nums) {
            int hh1 = num / 100;
            int mm1 = num % 100;
            int diff = (hh1 - hh0) * 60 + (mm1 - mm0);
            if (diff > 0 && diff < min_diff) {
                min_diff = diff;
                result = num;
            }
        }
        return String.format("%02d:%02d", result / 100, result % 100);
    }

    private void dfs(List<Integer> result, int i, int num, Set<Integer> digits) {
        if (i == 4) {
            result.add(num);
            return;
        }
        for (int d : digits) {
            dfs(result, i + 1, num * 10 + d, digits);
        }
    }


    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * Apple on-site problem: max time
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public String maxTime(String time) {
        Integer[] digits = new Integer[]{
                time.charAt(0) - '0',
                time.charAt(1) - '0',
                time.charAt(3) - '0',
                time.charAt(4) - '0'
        };
        Arrays.sort(digits, Collections.reverseOrder());
        int[] result = new int[4];
        result[0] = find(digits, 0, 2);
        result[1] = find(digits, 0, result[0] == 2 ? 4 : 9);
        result[2] = find(digits, 0, 5);
        result[3] = find(digits, 0, 9);
        return String.format("%d%d:%d%d", result[0], result[1], result[2], result[3]);
    }

    private int find(Integer[] digits, int l, int r) {
        for (int digit : digits) {
            if (digit >= l && digit <= r) return digit;
        }
        return -1;
    }

}
