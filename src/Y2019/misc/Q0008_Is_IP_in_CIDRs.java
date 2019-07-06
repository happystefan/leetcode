package Y2019.misc;

public class Q0008_Is_IP_in_CIDRs {

    class TreeNode {
        TreeNode left;
        TreeNode right;
    }

    public boolean isIPInCIDRs(int[] cidrs, int[] masks, int ip) {
        if (cidrs == null || cidrs.length == 0) return false;
        int n = cidrs.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(cidrs[i]);
            int len = Integer.bitCount(masks[i]);
            strs[i] = str.substring(0, len+1);
        }
        TreeNode root = new TreeNode();
        for (String str : strs) {
            insertPath(root, str.toCharArray(), 0, true);
        }
        for (char c : Integer.toBinaryString(ip).toCharArray()) {
            if (root.left == null && root.right == null) return true;
            TreeNode next = c == '0' ? root.left : root.right;
            if (next == null) return false;
            root = next;
        }
        return root.left == null && root.right == null;
    }

    private void insertPath(TreeNode root, char[] ss, int i, boolean firstCall) {
        if (i == ss.length) {
            root.left = null;
            root.right = null;
            return;
        }
        if (root.left == null && root.right == null && !firstCall) return;
        if (ss[i] == '0') {
            if (root.left == null) root.left = new TreeNode();
            insertPath(root.left, ss, i+1, false);
        }
        if (ss[i] == '1') {
            if (root.right == null) root.right = new TreeNode();
            insertPath(root.right, ss, i+1, false);
        }
    }

}
