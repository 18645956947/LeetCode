package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. �������Ĳ�ƽ��ֵ
 * @author zhx
 * �������и�С�ӣ�����ʱû���ǵ���������ӿ��ܻᳬ��int�ķ�Χ��������
 */
public class AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            double sum = 0;
            for(int i=0;i<list.size();i++){
                sum+=list.get(i);
            }
            double q = sum/(double) list.size();
            result.add(q);
        }
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right  = new TreeNode(2147483647);
        List<Double> l = AverageOfLevels.averageOfLevels(root);
        for(int i = 0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
