package Coding_Interviews;

/**
 * ½£Ö¸offer -- ×óÐý×ª×Ö·û´®
 * @author zhx
 */
public class ×óÐý×ª×Ö·û´® {

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
