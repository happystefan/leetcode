package Y2018.tree;

public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree_C {

    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean verify(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }
        if (start == end) {
            return preorder[start] > min && preorder[start] < max;
        }
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                break;
            }
        }
        if (i > end) {
            for (i = start + 1; i <= end; i++) {
                if (preorder[i] <= min || preorder[i] >= max) {
                    return false;
                }
            }
        }
        return verify(preorder, start + 1, i - 1, min, preorder[start]) && verify(preorder, i, end, preorder[start], max);
    }

}
