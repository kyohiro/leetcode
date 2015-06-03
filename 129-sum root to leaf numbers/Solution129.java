/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        else
            return subSum(root, 0);
    }

    private int subSum(TreeNode root, int num) {
        int crt = num * 10 + root.val;
        int ret = 0;
        if (root.left != null)
            ret += subSum(root.left, crt);
        if (root.right != null)
            ret += subSum(root.right, crt);

        if (root.left == null && root.right == null)
            return crt;
        else
            return ret;
    }
}