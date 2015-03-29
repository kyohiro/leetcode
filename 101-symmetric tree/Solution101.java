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
    //Attempt1: 243ms - recursive
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

    //Attempt2: 311ms - non-recursive
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.push(root.left);
        rightStack.push(root.right);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if (left == null && right == null)
                continue;
            else if (left == null || right == null)
                return false;
            else if (left.val != right.val) 
                return false;

            leftStack.push(left.left);
            rightStack.push(right.right);
            leftStack.push(left.right);
            rightStack.push(right.left);
        }

        return true;
    }

}