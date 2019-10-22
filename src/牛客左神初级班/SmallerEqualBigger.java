package 牛客左神初级班;

/**
 * 实现链表的Partition过程
 * 大于target 放右边 等于放中间 小于放左边
 *
 * @author zhx
 */
public class SmallerEqualBigger {


    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
           this.value = value;
        }
    }

    //链表的partition 用数组实现，没有稳定性，直接把所有的数据直接放入数组中，然后遍历 判断 最后交换值
    public static Node listPartition1(Node head, int pivot){
        if(head == null){
            return null;
        }

        Node cur = head;
        int i = 0; //得出链表的大小
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) { // 最后再把数组存储的节点连起来
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big){
            if(nodeArr[index].value < pivot){
                swap(nodeArr, ++small, index++);
            }else if(nodeArr[index].value == pivot){
                index++;
            }else {
                swap(nodeArr, --big, index); // 这里不再交换是因为要继续判断交换过来的值与pivot的大小关系
            }
        }

    }

    public static void swap(Node[] nodeArr, int a, int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    // 利用small equal big 三个链表，这样放的时候就有
    public static Node listPartition2(Node head, int pivot){
        if(head == null){
            return null;
        }
        //定义三个三个链表。用六个变量保存这三个链表的最小值最大值，然后首尾相连
        //小的链表
        Node sH = null;
        Node sT = null;

        //相等链表
        Node eH = null;
        Node eT = null;

        //大的链表
        Node bH = null;
        Node bT = null;

        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else{
                if(head.value > pivot){
                    if(bH == null){
                        bH = head;
                        bT = head;
                    }else {
                        bT.next = head;
                        bT = head;
                    }
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//         head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

}
