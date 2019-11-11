package ţ�����������.������;

import javax.print.DocFlavor;

/**
 * ǰ׺��
 * @author zhx
 */
public class TrieTree {
    //�ڵ�Ķ���
    public static class TrieNode {
        //�ڹ�������ʱ��ڵ㾭���ĸ���
        public int path;
        //������ַ�������
        public int end;
        //���������·��
        public TrieNode[] nexts;
        public TrieNode(){
            path = 0;
            end = 0;
            //ֱ�Ӷ�Ӧ��a~z 26��Ӣ����ĸ
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        //�����ַ����Ĳ���������ǰ׺��
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

        //ɾ��ָ�����ַ���
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

        //���Ҳ������������ַ���
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

        //������preΪǰ׺���ַ����ĸ���
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
