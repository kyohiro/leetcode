/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution094 {
    //Attempt1: recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) 
            return new ArrayList<Integer>(); 
        else {
            List<Integer> left = inorderTraversal(root.left);
            left.add(root.val);
            left.addAll(inorderTraversal(root.right));
            return left;
        }
    }

    //Attempt2: loop with stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null)
            return results;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                current = stack.pop();
                results.add(current.val);
                current = current.right;
            }
        }
        return results;
    }
}