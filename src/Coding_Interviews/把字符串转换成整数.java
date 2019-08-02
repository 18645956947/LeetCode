package Coding_Interviews;

/**
 * 剑指offer -- 把字符串转换成整数
 * @author zhx
 */
public class 把字符串转换成整数 {

    public static boolean flag;
    public static int StrToInt(String str) {
        flag = false;
        if(str == null || str.trim().equals("")){
            return 0;
        }
        int symbol = 0;//判断是 否为正数
        int start = 0;//判断第一个是否为符号位
        char[] chars = str.trim().toCharArray();
        if(chars[0] == '+'){
            start = 1;
        }
        else if(chars[0] == '-'){
            symbol = 1;
            start = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if(chars[i] > '9' || chars[i] < '0'){
                flag = true;
                return 0;
            }
            int sum = result * 10 + (chars[i] - '0');
            if((sum - (chars[i] - '0'))/10 != result){
                flag = true;
                return 0;
            }
            result = result * 10 + (chars[i] - '0');
        }

        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }

    public static void main(String[] args) {
        String str = "53651313";
        System.out.println(把字符串转换成整数.StrToInt(str));
        char[] c = str.trim().toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println((c[i] - '0'));
        }
        Integer f = 3;
        System.out.println(f.getClass().getSimpleName());
    }
}
