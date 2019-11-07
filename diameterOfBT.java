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
    public int dist = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root!= null){
            //dist = 1;
            findChildren(root);
            return dist--;
        }
        else return -1;
    }
    
    public int findChildren(TreeNode root){
        if (root == null) 
            return 0;
        
        int left = findChildren(root.left);
        int right = findChildren(root.right);
        dist = Math.max(dist, left+right);
        return Math.max(left, right) + 1;
        
    }
}
