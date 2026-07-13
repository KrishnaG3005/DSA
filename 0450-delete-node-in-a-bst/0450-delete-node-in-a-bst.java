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
    public TreeNode parent;

    public TreeNode deleteNode(TreeNode root, int key) {
        parent = null;
        TreeNode d = searchInBST(root, key);
        return delete(root, d);
    }

    TreeNode searchInBST(TreeNode p, int val) {
        while (p != null && p.val != val) {
            parent = p;
            if (val > p.val)
                p = p.right;
            else
                p = p.left;
        }
        return p;
    }

    TreeNode successor(TreeNode p) {
        parent = p;
        p = p.right;
        while (p.left != null) {
            parent = p;
            p = p.left;
        }
        return p;
    }

    TreeNode delete(TreeNode root, TreeNode d) {
        if (d != null) {

            // Case 1 : Leaf Node
            if (d.left == null && d.right == null) {
                if (parent == null)
                    return null;
                else {
                    if (d.val < parent.val)
                        parent.left = null;
                    else
                        parent.right = null;
                }
                return root;
            }

            // Case 2.1 : Having only left
            if (d.left != null && d.right == null) {
                if (parent == null)
                    root = d.left;
                else {
                    if (d.val < parent.val)
                        parent.left = d.left;
                    else
                        parent.right = d.left;
                }
                return root;
            }

            // Case 2.2 : Having only right
            if (d.left == null && d.right != null) {
                if (parent == null)
                    root = d.right;
                else {
                    if (d.val < parent.val)
                        parent.left = d.right;
                    else
                        parent.right = d.right;
                }
                return root;
            }

            // Case 3 : Having both children
            TreeNode s = successor(d);
            d.val = s.val;
            return delete(root, s);
        }

        return root;
    }
}