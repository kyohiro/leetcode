/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution199 {
    //Attempt1: 248ms
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root != null)
            scanNode(root, 1, results);
        return results;
    }

    private void scanNode(TreeNode node, int level, List<Integer> results) {
        if (node == null)
            return;
        if (results.size() < level)
            results.add(node.val);
        scanNode(node.right, level + 1, results);
        scanNode(node.left, level + 1, results);
    }
}