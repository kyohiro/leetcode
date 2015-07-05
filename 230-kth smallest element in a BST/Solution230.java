/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution230 {
    //Attempt1: count nodes of left sub tree
    public int kthSmallest(TreeNode root, int k) {
        int leftCounts = countNodes(root.left);
        if (leftCounts >= k)
            return kthSmallest(root.left, k);
        else if (leftCounts + 1 < k)
            return kthSmallest(root.right, k - leftCounts - 1);
        else
            return root.val;
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
