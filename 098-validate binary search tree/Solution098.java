/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        return subBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    } 

    private boolean subBST(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        else if (root.val <= minValue || root.val >= maxValue) 
            return false;
        else 
            return subBST(root.left, minValue, root.val) && subBST(root.right, root.val, maxValue);
    }
}