package 牛客进阶班;

import List.LRUCache;

import java.util.HashMap;

public class LFU {
    public static class Node{
        //这是key
        public Integer key;
        //value
        public Integer value;
        //出现的次数
        public Integer times;
        //该节点的上一个节点
        public Node up;
        //该节点的下一个节点
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }

    }

    public static class LFUCache{
        //容量
        private int capacity;
        //当前的个数
        private int size;
        //这个是存储key-Node,根据key找Node
        private HashMap<Integer, Node> records;
        //这个是Node-NodeList 根据Node找对应的次数的NodeList
        private HashMap<Node, NodeList> heads;
        //这个是整个NodeList的头链表，也就是次数最少的
        private NodeList headList;
        //下面是初始化操作
        public LFUCache(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        //put逻辑
        public void put(Integer key, Integer value){
            //如果这个key存在，那么直接更新value,次数加一，然后移动到存储该次数加一的NodeList中
            if (records.containsKey(key)){
                Node node = records.get(key);
                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node);
                //移动到存储该次数加一的NodeList中
                move(node, curNodeList);
            }else{
                //不存在，那么需要自己创建一个Node ，但是需要看下目前的容量问题
                //如果容量为0，那么直接返回就好
                if(capacity == 0){
                    return;
                }
                //如果容量到了，需要删除次数最小的node
                if (size == capacity){
                    //次数最小的node就是我们的头NodeList中的尾节点，因为我们插入都是头插法
                    Node node = headList.tail;
                    //删除该节点
                    headList.deleteNode(node);
                    //调整链表结构，该函数是看是否需要删除整个的NodeList
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                // 新建一个node
                Node node = new Node(key, value, 1);
                if (headList == null){
                    headList = new NodeList(node);
                }else{
                    if (headList.head.times.equals(node.times)){
                        headList.addNodeFromHead(node);
                    }else{
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }
        }

        public int get(Integer key){
            if (!records.containsKey(key)){
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList curNodeList = heads.get(node);
            move(node, curNodeList);
            return node.value;
        }

        //判断是否需要删除这个nodeList 如果这个list没有元素了，那么需要删除 返回true 否则返回false
        public boolean modifyHeadList(NodeList nodeList){
            if (nodeList.isEmpty()){
                if (headList == nodeList){
                    headList = nodeList.next;
                    if (headList != null){
                        headList.last = null;
                    }
                }else{
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null){
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;

        }
        //将新的Node移动到一个新的nodeList上面
        public void move(Node node, NodeList oldNodeList){
            oldNodeList.deleteNode(node);
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
            NodeList nextList = oldNodeList.next;
            //如果该list为最后一个，那么需要自己新建一个list
            if (nextList == null){
                NodeList newList = new NodeList(node);
                if (preList != null){
                    preList.next = newList;
                }
                newList.last = preList;
                //很有可能 目前头list为null
                if (headList == null){
                    headList = newList;
                }
                heads.put(node, newList);
            }else{
                //如果该list为中间的一个
                if (nextList.head.times.equals(node.times)){
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                }else{
                    //如果下一个list的词频不是该node词频+1 的话，那么自己中间添加一个list
                    NodeList newList = new NodeList(node);
                    if (preList != null){
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList){
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }


        public static class NodeList{
            public Node head;
            public Node tail;
            public NodeList last;
            public NodeList next;
            public NodeList(Node node){
                head = node;
                tail = node;
            }
            public void addNodeFromHead(Node newHead){
                newHead.down = head;
                head.up = newHead;
                head = newHead;
            }
            public boolean isEmpty(){
                return head == null;
            }
            public void deleteNode(Node node){
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    if (node == head){
                        head = node.down;
                        head.up = null;
                    }else if (node == tail){
                        tail = node.up;
                        tail.down = null;
                    }else {
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;
            }


        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(0);
        cache.put(0, 0);
        cache.put(0, 0);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));

    }
}
