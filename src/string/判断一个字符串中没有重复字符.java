package string;

/**
 * 不可以用其他数据结构 判断字符串是否有重复元素
 * 利用一个位数组 一个int 可以代表4个字节，也就是32个比特位
 * @author zhx
 *
 * */
public class 判断一个字符串中没有重复字符 {

    public static boolean isUnique(String astr) {
        int a = 0;
        for(int i = 0;i < astr.length();i++){
            int index = astr.charAt(i) - 'a';
            if((a & (1<<index)) > 0){
                return false;
            }
            a |= 1<<index;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcsss"));
    }
}
