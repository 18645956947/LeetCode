package 牛客进阶班;

/**
 * KMP算法 -- 给两个字符串 是s1, s2  看s1中是否包含s2 包含的话返回开始位置的索引
 */
public class KMP {


    public static int getIndexOf(String s1, String s2){
        if (s1 == null || s2 == null || s2.length() < 1 || s2.length() > s1.length()){
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length){
            if (str2[i - 1] == str2[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
    public static void print(int[] a){
        for (int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "acf";
        String str2 = "f";
        int res = getIndexOf(str1, str2);
        System.out.println(res);

    }

}
