/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root, q = null;
        //TreeNode temp=new TreeNode(val, null,null);
        TreeNode temp = new TreeNode();
        temp.val = val;
        temp.left = null;
        temp.right = null;

        while( p!= null){
            q= p;
            if(val <p.val)
                p=p.left;
            else
                p=p.right;
        }
        if(q == null)
            return temp;
        else{
            if(val<q.val)
                q.left=temp;
            else
                q.right=temp;
        }
        return root;
    }
}