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
 * 589. N叉树的前序遍历
 * @author zhx
 * @desc 非递归就是借助栈，先将根节点压入栈。
 * 然后开始循环，每次出栈一个元素，并将出栈的元素的孩子从右到左压入栈中（如果有的话），
 * 这样的顺序就是前序遍历的顺序了
 *
 */
public class Preorder {
    //迭代方法
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
    //递归的方法
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
