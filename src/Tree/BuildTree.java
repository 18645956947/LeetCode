package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author zhx
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 && inorder.length == 0){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return generator(preorder, inorder, map, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode generator(int[] preorder, int[] inorder, Map<Integer, Integer> map, int preStart, int preEnd, int inStart, int inEnd){
        TreeNode node = new TreeNode(preorder[preStart]);
        //该节点已经没有孩子节点了
        if(preStart == preEnd && inStart == inEnd){
            return node;
        }

        //找到中序遍历根节点的位置
        int rootPosition = map.get(preorder[preStart]);

        //找出左右子树节点个数
        int leftLen = rootPosition - inStart;
        int rigthLen = inEnd - rootPosition;

        if(leftLen > 0){
            node.left = generator(preorder, inorder, map, preStart + 1, preStart + leftLen, inStart, rootPosition - 1);
        }
        if(rigthLen > 0){
            node.right = generator(preorder, inorder, map, preStart + leftLen+1, preEnd, rootPosition + 1, inEnd);
        }
        return node;

    }


}

