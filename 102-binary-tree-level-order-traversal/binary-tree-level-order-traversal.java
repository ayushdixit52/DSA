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
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        if(root==null){
            return result;
        }
        while(!queue.isEmpty()){
           int  levelsize=queue.size();
            List<Integer> currlevel=new LinkedList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode currNode=queue.poll();
                currlevel.add(currNode.val);
                if(currNode.left!=null){
                    queue.offer(currNode.left);
                }
                if(currNode.right!=null){
                    queue.offer(currNode.right);
                }
            }
            result.add(currlevel);
        }
        return result;
    }
}