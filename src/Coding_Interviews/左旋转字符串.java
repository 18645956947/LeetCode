package Coding_Interviews;

/**
 * ��ָoffer -- ����ת�ַ���
 * @author zhx
 */
public class ����ת�ַ��� {

    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        System.out.println(len);
        if(len == 0){
            return "";
        }
        int s = n % len;//1
        System.out.println(s);
        String st = str + str;
        System.out.println(st);
        return st.substring(s, s+len);
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(LeftRotateString(s, 7));
    }
}
