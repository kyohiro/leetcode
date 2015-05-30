/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution102 {
    //Attempt1: 340ms
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();       
        if (root == null)
            return results;
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            List<TreeNode> tmpNodes = new ArrayList<TreeNode>();
            List<Integer> subResults = new ArrayList<Integer>();
            for (int i = 0; i < levelNodes.size(); ++i) {
                TreeNode node = levelNodes.get(i);
                subResults.add(node.val);
                if (node.left != null)
                    tmpNodes.add(node.left);
                if (node.right != null)
                    tmpNodes.add(node.right);
            }
            results.add(subResults);
            levelNodes = tmpNodes;
        }

        return results;
    }
}