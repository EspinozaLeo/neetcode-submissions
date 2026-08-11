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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tuples = new ArrayList<>();
        dfs(root, tuples, 0);
        return tuples;

    }

    private void dfs(TreeNode node, List<List<Integer>> tup, int depth){
        if(node == null) return;

        if(tup.size() == depth){
            tup.add(new ArrayList<>());
        }

        tup.get(depth).add(node.val);
        dfs(node.left, tup, depth + 1);
        dfs(node.right, tup, depth + 1);
    }
}