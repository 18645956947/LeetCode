package Coding_Interviews;

/**
 * 剑指offer---二叉搜索树的后序遍历序列
 * @author zhx
 */
public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if(start >= end){
            return true;
        }
        //后续遍历中最后一个节点就是根节点
        int root = sequence[end];
        int i = start;
        //i左边的除了跟节点就是左子树  i右边的包括i就是右子树
        while(sequence[i] < root){
            i++;
        }

        //该函数是用来判断右子树的每一个值是否比根节点大
        for(int j = i;j < end;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        //判断左子树是否为一个后序遍历的二叉搜索树
        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        //判断右子树是否为一个后序遍历的二叉搜索树
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;

    }
}
