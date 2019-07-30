package Coding_Interviews;

/**
 * 剑指offer -- 翻转单词顺序列
 * @author zhx
 */
public class 翻转单词顺序列 {

    public static String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        for (i = a.length ; i > 0; i--) {
            sb.append(a[i-1]);
            if(i > 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "student. a am I";
        System.out.println(翻转单词顺序列.ReverseSentence(str));
    }
}
