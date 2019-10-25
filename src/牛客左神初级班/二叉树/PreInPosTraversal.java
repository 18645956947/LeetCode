package 牛客左神初级班.二叉树;

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node{
        public  int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
    // 递归版先序遍历二叉树
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 递归版中序遍历二叉树
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }
    // 递归版后序遍历二叉树
    public static void postOrderRecur(Node head){
        if(head == null) {
            return;
        }
        inOrderRecur(head.left);
        inOrderRecur(head.right);
        System.out.println(head.value);
    }

    //非递归版本 先序遍历二叉树
    public static void preOrderUnRecur(Node head) {
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.value);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.right != null){
                stack.push(temp.left);
            }
        }
    }

    //非递归版本 中序遍历二叉树
    public static void inOrderUnRecur(Node head) {
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }

    //非递归版本 后序遍历二叉树
    public static void postOrderUnRecur(Node head) {
        if(head != null){
            Stack<Node> stack= new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                help.push(head);
                if(head.left != null){
                    stack.push(head.left);
                }
                if(head.right != null){
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()){
                Node tem = help.pop();
                System.out.println(tem.value);
            }
        }
    }

}
