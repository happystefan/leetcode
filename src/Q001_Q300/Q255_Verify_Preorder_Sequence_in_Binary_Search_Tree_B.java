package Q001_Q300;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree_B {

    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE, i = -1;
        for (int n : preorder) {
            if (n < min) return false;
            while (i >= 0 && n > preorder[i]) {
                min = preorder[i--];
            }
            preorder[++i] = n;
        }
        return true;
    }

}
