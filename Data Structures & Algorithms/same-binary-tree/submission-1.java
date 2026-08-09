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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // ArrayList<TreeNode> treeNodesA = new ArrayList<>();
        // ArrayList<TreeNode> treeNodesB = new ArrayList<>();
        // dfs(p, treeNodesA);
        // dfs(q, treeNodesB);
        // return treeNodesA.equals(treeNodesB);
        if(p == null && q == null){
            return true;
        }

        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else{
            return false;
        }
    }

    // private void dfs(TreeNode node, ArrayList nodes){
    //     if(node == null){
    //         nodes.add(null);
    //         return;
    //     }
    //     nodes.add(node.val);
    //     dfs(node.left, nodes);
    //     dfs(node.right, nodes);
    // }
}