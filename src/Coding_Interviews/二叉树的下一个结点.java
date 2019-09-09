package Coding_Interviews;

/**
 * ����һ�������������е�һ����㣬
 * ���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * ��ָoffer -- ����������һ�����
 * @author zhx
 */
public class ����������һ����� {

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return pNode;
        }
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        else if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        else if(pNode.next != null && pNode.next.right == pNode){
            while(pNode.next != null && pNode.next != pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }else{
            return pNode.next;
        }


    }
}
