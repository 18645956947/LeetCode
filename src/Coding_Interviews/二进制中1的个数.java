package Coding_Interviews;

/**
 * ��ָoffer -- ��������1�ĸ���
 * @author zhx
 */
public class ��������1�ĸ��� {

    public static int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int t = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                t++;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(��������1�ĸ���.NumberOf1(234));
    }
}
