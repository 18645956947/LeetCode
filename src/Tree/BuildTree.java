package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. ��ǰ��������������й��������
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
        //�ýڵ��Ѿ�û�к��ӽڵ���
        if(preStart == preEnd && inStart == inEnd){
            return node;
        }

        //�ҵ�����������ڵ��λ��
        int rootPosition = map.get(preorder[preStart]);

        //�ҳ����������ڵ����
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

