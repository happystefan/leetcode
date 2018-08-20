package archive.Q001_Q300;

public class Q123_Best_Time_to_Buy_and_Sell_Stock_III {

    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;
        for (int p : prices) {
            b1 = Math.max(b1, -p);
            s1 = Math.max(s1, p+b1);
            b2 = Math.max(b2, s1-p);
            s2 = Math.max(s2, b2+p);
        }
        return s2;
    }

}
