package List;

import java.util.HashMap;

/**
 * leetcode -- 146. LRU缓存机制
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
     * 在头节点插入一新节点
     * @param node
     */
    private void addNode(DLinkedNode node){

        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;

    }

    /**
     * 删除元素操作
     * @param node
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;

    }

    /**
     * 摘除一个元素并把它移动到开头
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 弹出最尾巴的节点
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
                //最后一个节点弹出
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        }else{
            //cache命中，更新cache
            node.value = value;
            this.moveToHead(node);
        }
    }

}
