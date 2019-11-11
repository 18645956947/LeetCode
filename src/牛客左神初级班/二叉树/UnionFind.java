package 牛客左神初级班.二叉树;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集的基础
 * 1.判断两个集合是否是一个
 * 2.把两个元素所在的集合连接起来
 * @author zhx
 */
public class UnionFind {

    public static class Node{
        // 任意的结构
    }

    public static class UnionFindSet{
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){
            makeSets(nodes);
        }
        private void makeSets(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node:nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }
        //思想就是不断的向上找直到遇到头节点，在这个过程中进行优化，把所有节点的父节点都设置为公共的最开始的父节点
        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }
        //判断两个点所在的结合是否是同一个集合
        private boolean isSameSet(Node a, Node b){
            return findHead(a) == findHead(b);
        }
        //把两个点所在的集合连接起来
        private void union(Node a, Node b){
            if(a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                }else{
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }

        }
    }
}
