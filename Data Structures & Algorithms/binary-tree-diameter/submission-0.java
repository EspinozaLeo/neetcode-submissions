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
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }
           
    private int dfs(TreeNode currRoot){
        if(currRoot == null){
            return 0;
        }
        int leftTree = dfs(currRoot.left);
        int rightTree = dfs(currRoot.right);
        result = Math.max(result, leftTree + rightTree);
        return 1 + Math.max(leftTree, rightTree);
    }
}