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
    public boolean isBalanced(TreeNode root) {
        boolean isItBalanced[] = new boolean[1];
        isItBalanced[0] = true;
        dfs(root, isItBalanced);
        return isItBalanced[0];
    }

    private int dfs(TreeNode currRoot, boolean[] arr){
        if(currRoot == null) return 0;

        int leftTree = dfs(currRoot.left, arr);
        int rightTree = dfs(currRoot.right, arr);
        if(Math.abs(leftTree - rightTree) > 1) arr[0] = false;
        return 1 + Math.max(leftTree, rightTree);
    }
}
