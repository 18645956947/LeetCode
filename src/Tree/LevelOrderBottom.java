package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. �������Ĳ�α��� II
 * @author zhx
 * @data 2019��03��18��
 *
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList();
        List<TreeNode> list=new ArrayList();
        if(root==null) return result;
        list.add(root);
        while(!list.isEmpty()){
            List<Integer> curList=new ArrayList();//ÿ�ε�ǰ��ڵ㶼Ҫ���³�ʼ��
            List<TreeNode> nextList=new ArrayList();//��ʼ����һ�����нڵ��list
            for(TreeNode cur:list){//cur�ǵ�ǰ�ڵ㣬list�ǵ�ǰ������нڵ�
                curList.add(cur.val);
                if(cur.left!=null) nextList.add(cur.left);//��һ��ڵ�
                if(cur.right!=null) nextList.add(cur.right);//��һ��ڵ�
            }
            list=nextList;
            result.add(0,curList);//��ǰ�����нڵ��list��������ؽ����
        }
        return result;
    }
}
