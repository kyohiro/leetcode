/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        return root;
    }
}