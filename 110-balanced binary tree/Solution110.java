/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //Attempt1: 303ms
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else
            return depth(root) > 0;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        int da = depth(node.left);
        int db = depth(node.right);
        if (Math.abs(da - db) >= 2 || da < 0 || db < 0)
            return -2;
        else
            return Math.max(da + 1, db + 1);
    }
}
