package string;

/**
 * 反转字符串
 * @author zhx
 * 输入一个字符串，一个数字m，反转前m个字符串 例如;输入("abcde", 2) -> ("cdeab")
 */
public class 反转前m个字符串 {

    public static void main(String[] args) {
        //char[] a = new char[]{'a', 'b', 'c', 'd', 'e'};
        char[] a = new char[]{'l', 'o'};

        System.out.println("反转前");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        反转前m个字符串.reserve(a, 2);
        System.out.println();
        System.out.println("反转后");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static void reserve(char[] s, int m){
        help(s, 0, s.length - 1);
        help(s, 0, s.length - m - 1);
        help(s, s.length - m, s.length - 1);
    }
    public static void help(char[] s, int start, int end){
        for(int i = start;i < start + (end - start + 1) / 2;i++){
            swap(s, i, end + start - i);
        }
    }
    public static void swap(char[] s, int a, int b){
        char c = s[a];
        s[a] = s[b];
        s[b] = c;
    }
}
