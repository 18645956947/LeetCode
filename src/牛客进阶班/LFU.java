package ţ�ͽ��װ�;

import List.LRUCache;

import java.util.HashMap;

public class LFU {
    public static class Node{
        //����key
        public Integer key;
        //value
        public Integer value;
        //���ֵĴ���
        public Integer times;
        //�ýڵ����һ���ڵ�
        public Node up;
        //�ýڵ����һ���ڵ�
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }

    }

    public static class LFUCache{
        //����
        private int capacity;
        //��ǰ�ĸ���
        private int size;
        //����Ǵ洢key-Node,����key��Node
        private HashMap<Integer, Node> records;
        //�����Node-NodeList ����Node�Ҷ�Ӧ�Ĵ�����NodeList
        private HashMap<Node, NodeList> heads;
        //���������NodeList��ͷ����Ҳ���Ǵ������ٵ�
        private NodeList headList;
        //�����ǳ�ʼ������
        public LFUCache(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        //put�߼�
        public void put(Integer key, Integer value){
            //������key���ڣ���ôֱ�Ӹ���value,������һ��Ȼ���ƶ����洢�ô�����һ��NodeList��
            if (records.containsKey(key)){
                Node node = records.get(key);
                node.value = value;
                node.times++;
                NodeList curNodeList = heads.get(node);
                //�ƶ����洢�ô�����һ��NodeList��
                move(node, curNodeList);
            }else{
                //�����ڣ���ô��Ҫ�Լ�����һ��Node ��������Ҫ����Ŀǰ����������
                //�������Ϊ0����ôֱ�ӷ��ؾͺ�
                if(capacity == 0){
                    return;
                }
                //����������ˣ���Ҫɾ��������С��node
                if (size == capacity){
                    //������С��node�������ǵ�ͷNodeList�е�β�ڵ㣬��Ϊ���ǲ��붼��ͷ�巨
                    Node node = headList.tail;
                    //ɾ���ýڵ�
                    headList.deleteNode(node);
                    //��������ṹ���ú����ǿ��Ƿ���Ҫɾ��������NodeList
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                // �½�һ��node
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

        //�ж��Ƿ���Ҫɾ�����nodeList ������listû��Ԫ���ˣ���ô��Ҫɾ�� ����true ���򷵻�false
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
        //���µ�Node�ƶ���һ���µ�nodeList����
        public void move(Node node, NodeList oldNodeList){
            oldNodeList.deleteNode(node);
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
            NodeList nextList = oldNodeList.next;
            //�����listΪ���һ������ô��Ҫ�Լ��½�һ��list
            if (nextList == null){
                NodeList newList = new NodeList(node);
                if (preList != null){
                    preList.next = newList;
                }
                newList.last = preList;
                //���п��� ĿǰͷlistΪnull
                if (headList == null){
                    headList = newList;
                }
                heads.put(node, newList);
            }else{
                //�����listΪ�м��һ��
                if (nextList.head.times.equals(node.times)){
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                }else{
                    //�����һ��list�Ĵ�Ƶ���Ǹ�node��Ƶ+1 �Ļ�����ô�Լ��м����һ��list
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
