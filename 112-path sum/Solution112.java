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
    //Attempt1: 238ms
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null)
            return root.val == sum;
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}