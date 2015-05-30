/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution103 {
    //Attempt1: 300ms
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();       
        if (root == null)
            return results;
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        boolean reverse = false;

        while (!levelNodes.isEmpty()) {
            List<TreeNode> tmpNodes = new ArrayList<TreeNode>();
            List<Integer> subResults = new ArrayList<Integer>();
            for (int i = 0; i < levelNodes.size(); ++i) {
                TreeNode node = levelNodes.get(i);
                subResults.add(node.val);

                if (!reverse) {
                    if (node.left != null)
                        tmpNodes.add(node.left);
                    if (node.right != null)
                        tmpNodes.add(node.right);
                }
                else {
                    if (node.right != null)
                        tmpNodes.add(node.right);
                    if (node.left != null)
                        tmpNodes.add(node.left);
                }
            }

            results.add(subResults);
            levelNodes = tmpNodes;
            Collections.reverse(levelNodes);
            reverse = !reverse;
        }

        return results;
    }
}