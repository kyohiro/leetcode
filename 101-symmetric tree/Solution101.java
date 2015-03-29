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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else
            return isSymmetricForTwo(root.left, root.right);
    }

    private boolean isSymmetricForTwo(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        else if (left.val != right.val)
            return false;
        else
            return isSymmetricForTwo(left.left, right.right) && isSymmetricForTwo(left.right, right.left);

    }

}