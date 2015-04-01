/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution111 {
    //Attempt1: 253ms
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
        int da = minDepth(root.left);
        int db = minDepth(root.right);
        if (da == 0 && db == 0)
            return 1;
        else if (da == 0 || db == 0)
            return da + db + 1;
        else
            return Math.min(da + 1, db + 1);
    }
}