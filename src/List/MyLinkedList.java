package List;


/** 
* @author ZHX
* @date 2019年3月15日下午2:29:16 
* @Description: 707. 设计链表
*/
public class MyLinkedList {
	Node head;
    int size;
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    
    
    
    /** Initialize your data structure here. */
public MyLinkedList() {
    
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
public int get(int index) {
    if(index < 0 || index> size-1){
        return -1;
    }
    Node current = head;
    for(int i=0;current != null && i < index;i++){
        current = current.next;
    }
    return current.val;
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
public void addAtHead(int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    head = newNode;
    size++;
    
}

/** Append a node of value val to the last element of the linked list. */
public void addAtTail(int val) {
    Node newNode = new Node(val);
    if(head == null){
        head = new Node(val);
        size++;
        return;
    }
    newNode.next = null;
    Node tail = head;
    while(tail.next != null){
        tail = tail.next;
    }
    tail.next = newNode;
    size++;
    return;
        
    
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
public void addAtIndex(int index, int val) {
    if(index < 0 || index > size){
        return;
    }
   else if(index == size){
        addAtTail(val);
       return;
    }
    else if(index == 0){
         addAtHead(val);
        return;
    }
    else{
    Node newNode = new Node(val);
        Node current = head;
         for(int i=0;current != null && i < index-1;i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    size++;
    }
}

/** Delete the index-th node in the linked list, if the index is valid. */
public void deleteAtIndex(int index) {
    if(head == null){
        return;
    }
    Node current = head;
    if(index == 0){
        head = current.next;
        size--;
        return;
    }
    for(int i=0;current != null && i < index-1;i++){
        current = current.next;
    }
    if(current == null || current.next == null){
        return;
    }
    
    Node next = current.next.next;
    current.next = next;
    size--;
}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
 