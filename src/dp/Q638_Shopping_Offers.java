package dp;

import java.util.List;

public class Q638_Shopping_Offers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
        while (price.size() < 6) {
            price.add(0);
        }
        for (List<Integer> special : specials) {
            while (special.size() < 7) {
                special.add(special.size() - 1, 0);
            }
        }
        while (needs.size() < 6) {
            needs.add(0);
        }
        int[][][][][][] dp = new int[7][7][7][7][7][7];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                for (int k = 0; k < 7; k++)
                    for (int l = 0; l < 7; l++)
                        for (int m = 0; m < 7; m++)
                            for (int n = 0; n < 7; n++) {
                                dp[i][j][k][l][m][n] = i * price.get(0) + j * price.get(1) + k * price.get(2) + l * price.get(3) + m * price.get(4) + n * price.get(5);
                            }

        for (List<Integer> special : specials) {
            for (int i = special.get(0); i < 7; i++)
                for (int j = special.get(1); j < 7; j++)
                    for (int k = special.get(2); k < 7; k++)
                        for (int l = special.get(3); l < 7; l++)
                            for (int m = special.get(4); m < 7; m++)
                                for (int n = special.get(5); n < 7; n++) {
                                    dp[i][j][k][l][m][n] = Math.min(dp[i][j][k][l][m][n], dp[i - special.get(0)][j - special.get(1)][k - special.get(2)][l - special.get(3)][m - special.get(4)][n - special.get(5)] + special.get(6));
                                }

        }

        /* This will Time Limit Exceeded
        {
            for (int i = 0; i < 7; i++)
                for (int j = 0; j < 7; j++)
                    for (int k = 0; k < 7; k++)
                        for (int l = 0; l < 7; l++)
                            for (int m = 0; m < 7; m++)
                                for (int n = 0; n < 7; n++) {
                                    for (List<Integer> special : specials) {
                                        if (i + special.get(0) < 7 &&
                                                j + special.get(1) < 7 &&
                                                k + special.get(2) < 7 &&
                                                l + special.get(3) < 7 &&
                                                m + special.get(4) < 7 &&
                                                n + special.get(5) < 7
                                                ) {

                                            archive.dp[i + special.get(0)]
                                                    [j + special.get(1)]
                                                    [k + special.get(2)]
                                                    [l + special.get(3)]
                                                    [m + special.get(4)]
                                                    [n + special.get(5)] = Math.min(
                                                    archive.dp[i + special.get(0)]
                                                            [j + special.get(1)]
                                                            [k + special.get(2)]
                                                            [l + special.get(3)]
                                                            [m + special.get(4)]
                                                            [n + special.get(5)], archive.dp[i][j][k][l][m][n] + special.get(6)
                                            );

                                        }
                                    }

                                }
        }
        */
        return dp[needs.get(0)][needs.get(1)][needs.get(2)][needs.get(3)][needs.get(4)][needs.get(5)];
    }

}
