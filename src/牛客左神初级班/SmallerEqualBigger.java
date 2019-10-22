package ţ�����������;

/**
 * ʵ�������Partition����
 * ����target ���ұ� ���ڷ��м� С�ڷ����
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

    //�����partition ������ʵ�֣�û���ȶ��ԣ�ֱ�Ӱ����е�����ֱ�ӷ��������У�Ȼ����� �ж� ��󽻻�ֵ
    public static Node listPartition1(Node head, int pivot){
        if(head == null){
            return null;
        }

        Node cur = head;
        int i = 0; //�ó�����Ĵ�С
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
        for (i = 1; i != nodeArr.length; i++) { // ����ٰ�����洢�Ľڵ�������
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
                swap(nodeArr, --big, index); // ���ﲻ�ٽ�������ΪҪ�����жϽ���������ֵ��pivot�Ĵ�С��ϵ
            }
        }

    }

    public static void swap(Node[] nodeArr, int a, int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    // ����small equal big �������������ŵ�ʱ�����
    public static Node listPartition2(Node head, int pivot){
        if(head == null){
            return null;
        }
        //�������������������������������������������Сֵ���ֵ��Ȼ����β����
        //С������
        Node sH = null;
        Node sT = null;

        //�������
        Node eH = null;
        Node eT = null;

        //�������
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
