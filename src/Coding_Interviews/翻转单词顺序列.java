package Coding_Interviews;

/**
 * ��ָoffer -- ��ת����˳����
 * @author zhx
 */
public class ��ת����˳���� {

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
        System.out.println(��ת����˳����.ReverseSentence(str));
    }
}
