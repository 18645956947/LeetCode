package ��ָoffer.��;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָoffer - ���л�������
 * @author zhx
 */
public class ���л������� {

    String Serialize(TreeNode root) {
        if(root == null){
            return "#!";
        }
        String s = root.val + "!";
        s += Serialize(root.left);
        s += Serialize(root.right);
        return s;
    }
    TreeNode Deserialize(String str) {
        String[] aa = str.split("!");
        Queue<String> queue = new LinkedList();
        for(int i = 0; i < aa.length; i++){
            queue.add(aa[i]);
        }
        return generate(queue);
    }
    public TreeNode generate(Queue<String> queue){
        String a = queue.poll();
        if(a.equals("#")){
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(a));
        cur.left = generate(queue);
        cur.right = generate(queue);
        return cur;
    }
}
