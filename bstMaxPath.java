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
    public int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = root.val;
        if (root != null){
            findPath(root);
        }
        
        return maxPath;
    }
    
    public int findPath(TreeNode node){
        if (node == null)
            return 0;
        
        int left = 0;
        int right = 0;
        
        if(node.left!=null){
             left = findPath(node.left);
        if (left < 0){
            left = 0;
        }
        }
        
        if(node.right != null){
            right = findPath(node.right);
        if(right <0){
            right = 0;
        }
        }
        
        int tempMax = left + right +node.val;
        maxPath = Math.max(maxPath, tempMax);
        
        return Math.max(left, right)+ node.val;
    }
}