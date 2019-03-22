package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
 * 589. N������ǰ�����
 * @author zhx
 * @desc �ǵݹ���ǽ���ջ���Ƚ����ڵ�ѹ��ջ��
 * Ȼ��ʼѭ����ÿ�γ�ջһ��Ԫ�أ�������ջ��Ԫ�صĺ��Ӵ��ҵ���ѹ��ջ�У�����еĻ�����
 * ������˳�����ǰ�������˳����
 *
 */
public class Preorder {
    //��������
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            for(int i = root.children.size() -1;i>=0;i--){
                stack.push(root.children.get(i));
            }
        }
        return res;
    }
    //�ݹ�ķ���
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder_01(Node root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        for(Node node : root.children){
            preorder_01(node);
        }
        return list;
    }
}
