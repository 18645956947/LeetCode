package ��ָoffer.λ����;

/**
 * ��ָoffer - �ж�һ�����Ƿ���2�ı���
 * @author zhx
 * �Լ����Լ�-1������λ����������������Լ�-1�����ô�Ͳ���2�ı���
 */
public class �ж�һ�����Ƿ���2�ı��� {
    public static boolean isTwo(int n){
        int m = n - 1;
        n = n & m;
        if(n == m){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(�ж�һ�����Ƿ���2�ı���.isTwo(99));
        System.out.println(new Float(0));
        System.out.println(Math.abs(-1));
    }
}
