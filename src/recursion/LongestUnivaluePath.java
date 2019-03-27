package recursion;

import Tree.TreeNode;

/**
 * 687. 最长同值路径
 */
public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] longestPath = new int[1];
        getUnivaluePathCount(root, longestPath);
        return longestPath[0];

    }
    public int getUnivaluePathCount(TreeNode node, int[] longestPath){
        int left = 0;
        if(node.left != null){
            left += getUnivaluePathCount(node.left, longestPath);
            if(node.val == node.left.val){
                left += 1;
            }
            else{
                left = 0;
            }
        }
        int right = 0;
        if(node.right != null){
            right += getUnivaluePathCount(node.right, longestPath);
            if(node.val == node.right.val){
                right+=1;
            }
            else{
                right = 0;
            }
        }
        int currentLongestPath;
        if(node.left != null && node.right != null && node.left.val == node.right.val){
            currentLongestPath = left + right;
        }
        else{
            currentLongestPath = Math.max(left, right);
        }
        if(currentLongestPath > longestPath[0]){
            longestPath[0] = currentLongestPath;
        }

        return Math.max(left, right);

    }
}
