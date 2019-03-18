package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * @author zhx
 * @data 2019年03月18日
 *
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList();
        List<TreeNode> list=new ArrayList();
        if(root==null) return result;
        list.add(root);
        while(!list.isEmpty()){
            List<Integer> curList=new ArrayList();//每次当前层节点都要重新初始化
            List<TreeNode> nextList=new ArrayList();//初始化下一层所有节点的list
            for(TreeNode cur:list){//cur是当前节点，list是当前层的所有节点
                curList.add(cur.val);
                if(cur.left!=null) nextList.add(cur.left);//下一层节点
                if(cur.right!=null) nextList.add(cur.right);//下一层节点
            }
            list=nextList;
            result.add(0,curList);//当前层所有节点的list倒插进返回结果中
        }
        return result;
    }
}
