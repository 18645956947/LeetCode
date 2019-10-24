package 牛客左神初级班;

/**
 * 返回两个链表的相接的第一个节点
 * @author zhx
 */
public class FindFirstIntersectNode {

    public static class Node{
        public  int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
        // 1.首先是判断两个链表是否有环，有的话返回其环的入口 没有返回null
        // 2.一共两种情况 （1）两个无环链表相交（2）两个有环链表相交
        // 至于为啥没有一个有环一个没环的 相交 因为我们的是单链表
        if(head1 == null || head2 == null){
            return null;
        }
        //1.先求两个节点的入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    //给一个链表 返回其入环第一个节点
    public static Node getLoopNode(Node head){
        //首先是最少三个节点才能成环
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node slow = head.next;
        Node first = head.next.next;
        while (first != slow){
            if(first.next == null || first.next.next == null){
                return null;
            }
            first = first.next.next;
            slow = slow.next;
        }
        first = head;
        while (first != slow){
            first = first.next;
            slow = slow.next;
        }
        return first;
    }

    //这是求 两个无环链表相交的第一个节点
    public static Node noLoop(Node head1, Node head2){
        int len1 = 0;
        int len2 = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (head1 != null){
            len1++;
            head1 = head1.next;
        }
        while (head2 != null){
            len2++;
            head2 = head2.next;
        }
        int n = len1 - len2;
        if(n > 0){
            while (n > 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != null){
                if(cur1 == cur2){
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
        }else if(n < 0){
            n = Math.abs(n);
            while (n > 0){
                n--;
                cur2 = cur2.next;
            }
            while (cur1 != null){
                if(cur1 == cur2){
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
        }else{
            while (cur1 != null){
                if(cur1 == cur2){
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
        }
    }

    //（2）两个有环链表相交 一共三种情况：
    // 1.无交点
    // 2.两个环的交点是一个
    // 3.两个环的交点不是一个
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        int n1 = 0;
        int n2 = 0;

        //第2种情况
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            while (cur1 != loop1){
                n1++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n2++;
                cur2 = cur2.next;
            }
            int n3 = n1 - n2;
            cur1 = head1;
            cur2 = head2;
            if(n3 > 0){
                while (n3 > 0){
                    n3--;
                    cur1 = cur1.next;
                }
                while (cur1 != loop1){
                    if(cur1 == cur2){
                        return cur1;
                    }
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;
            }else if(n3 < 0){
                n3 = Math.abs(n3);
                while (n3 > 0){
                    n3--;
                    cur2 = cur2.next;
                }
                while (cur1 != loop2){
                    if(cur1 == cur2){
                        return cur1;
                    }
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;
            }else {
                while (cur1 != loop1){
                    if(cur1 == cur2){
                        return cur1;
                    }
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;
            }
        } else{
            Node p = loop1.next;
            while (p != loop1){
                if(p == loop2){
                    return loop1;
                }
                p = p.next;
            }
            return null;
        }
    }
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        System.out.println(noLoop(head1, head2).value);


        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4



        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}

