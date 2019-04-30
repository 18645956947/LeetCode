package Tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * @author zhx
 */
public class BuildTree_inorder_postorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTree(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight){
        if(iLeft > iRight || pLeft > pRight){
            return null;
        }
        TreeNode cur = new TreeNode(postorder[pRight]);
        int i = 0;
        for(i = iLeft;i<inorder.length;i++){
            if(inorder[i] == cur.val)
                break;
        }
        cur.left = buildTree(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
        cur.right = buildTree(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
        return cur;
    }
}
