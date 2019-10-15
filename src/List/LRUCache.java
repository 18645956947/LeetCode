package List;

import java.util.HashMap;

/**
 * leetcode -- 146. LRU�������
 * @author zhx
 */
public class LRUCache {

    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;

    }

    /**
     * ��ͷ�ڵ����һ�½ڵ�
     * @param node
     */
    private void addNode(DLinkedNode node){

        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;

    }

    /**
     * ɾ��Ԫ�ز���
     * @param node
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;

    }

    /**
     * ժ��һ��Ԫ�ز������ƶ�����ͷ
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * ������β�͵Ľڵ�
     * @return
     */
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;
        head.post = tail;
        tail.pre = head;

    }
    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }else{
            this.moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if(count > capacity){
                //���һ���ڵ㵯��
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        }else{
            //cache���У�����cache
            node.value = value;
            this.moveToHead(node);
        }
    }

}
