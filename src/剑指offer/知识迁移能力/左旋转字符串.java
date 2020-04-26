package ½£Ö¸offer.ÖªÊ¶Ç¨ÒÆÄÜÁ¦;

/**
 * ½£Ö¸offer - ×óÐý×ª×Ö·û´®
 * @author zhx
 */
public class ×óÐý×ª×Ö·û´® {
    public String LeftRotateString(String str,int n) {
        if(str == "" || str.length() == 0){
            return "";
        }
        int length = str.length();
        char[] chs = str.toCharArray();
        reverse(chs, 0, length - 1);
        //print(chs);
        reverse(chs, 0, length - n - 1);
        //print(chs);
        reverse(chs, length - n, length - 1);
        //print(chs);
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < chs.length;i++){
            sb.append(chs[i]);
        }
        return sb.toString();
    }
    public void reverse(char[] chs, int start, int end){
        for(int i = start;i < start + (end - start + 1)/2;i++){
            swap(chs, i, end + start - i);
        }
    }
    public void swap(char[] chs, int a, int b){
        char s = chs[a];
        chs[a] = chs[b];
        chs[b] = s;
    }
    public void print(char[] chs){
        for (char x:chs) {
            System.out.print(x);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "abcXYZd";
        ×óÐý×ª×Ö·û´® a = new ×óÐý×ª×Ö·û´®();
//        System.out.println(a.LeftRotateString(str, 3));
        a.LeftRotateString(str, 3);
    }
}
