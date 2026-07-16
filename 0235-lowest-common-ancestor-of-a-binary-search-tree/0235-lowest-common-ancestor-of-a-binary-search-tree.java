/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left= Math.min(p.val,q.val), right = Math.max(q.val,p.val);
        while(root.val <left || root.val > right){
            if(root.val <left)
                root = root.right;
            else
                root = root.left;
        }
        return root;
    }
}