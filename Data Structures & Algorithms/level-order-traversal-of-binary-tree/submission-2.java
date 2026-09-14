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
        // List<List<Integer>> tuples = new ArrayList<>();
        // dfs(root, tuples, 0);
        // return tuples;
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); //initialize

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();

            for(int i = q.size(); i > 0; i--){
                //pop whatever is in q and add to list if not null. Use poll since it
                //returns null if head is empty
                TreeNode node = q.poll();
                if(node != null){
                    level.add(node.val);
                    //add children
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(level.size() > 0){
                res.add(level);
            }
        }
        return res;
    }

    // private void dfs(TreeNode node, List<List<Integer>> tup, int depth){
    //     if(node == null) return;

    //     if(tup.size() == depth){
    //         tup.add(new ArrayList<>());
    //     }

    //     tup.get(depth).add(node.val);
    //     dfs(node.left, tup, depth + 1);
    //     dfs(node.right, tup, depth + 1);
    // }
}