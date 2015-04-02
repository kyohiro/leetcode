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
    //Attempt1: 279ms
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        subpathSum(root, sum, current, results);
        return results;
    }

    private void subpathSum(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result) {
        if (node == null)
            return;
        current.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == sum)
                result.add(new ArrayList<Integer>(current));
            current.remove(current.size() - 1);
            return;
        }
        else {
            subpathSum(node.left, sum - node.val, current, result);
            subpathSum(node.right, sum - node.val, current, result);
            current.remove(current.size() - 1);
            return;
        }
    }
}