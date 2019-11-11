package 牛客左神初级班.二叉树;

import javax.print.DocFlavor;

/**
 * 前缀树
 * @author zhx
 */
public class TrieTree {
    //节点的定义
    public static class TrieNode {
        //在构建树的时候节点经过的个数
        public int path;
        //插入的字符串个数
        public int end;
        //构造的树的路径
        public TrieNode[] nexts;
        public TrieNode(){
            path = 0;
            end = 0;
            //直接对应的a~z 26个英文字母
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        //插入字符串的操作，构造前缀树
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                //a -- 0, b --1, c -- 2, d --3, ... , z -- 25
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node.path++;
                node = node.nexts[index];
            }
            node.end++;
        }

        //删除指定的字符串
        public void delete(String word){
            if(search(word) == 0){
                return;
            }
            int index = 0;
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(--node.nexts[index].path == 0){
                    node.nexts[index] = null;
                    return;
                }else{
                    node = node.nexts[index];
                }
            }
            node.end--;
        }

        //查找插入过几次这个字符串
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //查找以pre为前缀的字符串的个数
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] chs = pre.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
