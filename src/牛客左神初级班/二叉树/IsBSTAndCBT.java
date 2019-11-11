package 牛客左神初级班.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断是否是二叉搜索树
 * 判断是否是完全二叉树
 * @author zhx
 */
public class IsBSTAndCBT {

    //判断是否是二叉搜索树
    //思路是：看其二叉树的中序遍历是否是按照数值升序上升的
    //首先写一个二叉树的中序遍历
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if(head != null){
            double pre = - Double.MAX_VALUE;
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(head.value <= pre){
                        return false;
                    }
                    pre = head.value;
                    head = head.right;
                }
            }
        }
        return true;
    }

    //验证是否是完全二叉树
    //一共两种可能性：
    //1.如果一个节点有右子树没有左子树那么直接返回false
    //2.如果一个节点有左子树但是右子树为空或者有左右子树,那么其他节点都应该是叶子节点
    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((l == null && r != null) || (leaf && (l != null || r != null))){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }
            //开启判断其他叶子节点是否为空的阶段
            else{
                leaf = true;
            }
        }
        return true;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
