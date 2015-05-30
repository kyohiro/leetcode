/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution107 {
    //Attempt1: 275ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();           
        List<TreeNode> levelArray = new ArrayList<TreeNode>();
        if (root == null)
            return results;
        else 
            levelArray.add(root);

        while (!levelArray.isEmpty()) {
            List<Integer> levelResult = new ArrayList<Integer>();
            List<TreeNode> newLevelArray = new ArrayList<TreeNode>();
            for (TreeNode node : levelArray) {
                levelResult.add(node.val);
                if (node.left != null)
                    newLevelArray.add(node.left);
                if (node.right != null)
                    newLevelArray.add(node.right);
            }
            levelArray = newLevelArray;
            results.add(0, levelResult);
        }
        
        return results;
    }
}