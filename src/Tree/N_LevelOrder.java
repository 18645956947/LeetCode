package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * @author zhx
 * 测试数据代码在主函数里
 */
public class N_LevelOrder {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node temp = queue.poll();
                list.add(temp.val);
                if(temp.children!=null){
                    for (Node node : temp.children){
                        queue.offer(node);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args){
        Node child5 = new Node(11,null);
        Node child6 = new Node(12,null);
        Node child7 = new Node(21,null);
        List<Node> list2 = new ArrayList<>();
        list2.add(child5);
        list2.add(child6);
        list2.add(child7);
        Node child2 = new Node(2, list2);
        Node child3 = new Node(3, null);
        Node child4 = new Node(4, null);
        List<Node> list1 = new ArrayList<>();
        list1.add(child2);
        list1.add(child3);
        list1.add(child4);
        Node root = new Node(1, list1);

        System.out.println(N_LevelOrder.levelOrder(root));

    }
}
