/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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

    

        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        parents.put(root, null);

        TreeNode x;

        while (queue.size() != 0) {
            x = queue.remove();

            if (x.left != null) {
                queue.add(x.left);
                parents.put(x.left, x);
            }

            if (x.right != null) {
                queue.add(x.right);
                parents.put(x.right, x);
            }
        }

        while (p != null) {
            l1.add(p);
            p = parents.get(p);
        }

        while (q != null) {
            l2.add(q);
            q = parents.get(q);
        }

        Collections.reverse(l1);
        Collections.reverse(l2);

        int i = 0, j = 0;

        while (i < l1.size() &&
               j < l2.size() &&
               l1.get(i) == l2.get(j)) {
            i++;
            j++;
        }

        return l1.get(i - 1);
    }
}