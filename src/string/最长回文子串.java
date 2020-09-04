package string;

/**
 * 输入一个字符串 "abacd" 输出 "aba" 找出这个的最长的回文子串
 * @author zhx
 */
public class 最长回文子串 {

    //遍历的方式 - 中心扩展法
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        //遍历填充子串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        String s1 = sb.toString();
        System.out.println("s1:"+s1);
        int len = 0;
        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            System.out.println("第"+i+"轮");
            String ss = append(s1, i);
            System.out.println(ss);
            res = ss.length() > len ? ss : res;
            len = ss.length() > len ? ss.length():len;
            System.out.println(res);
        }
        return res.replace("#", "");
    }
    //返回回文子串
    public static String append(String str, int index){
        String res = "";
        for(int i = 0;i <= index && i < str.length() - index;i++){
            if(str.charAt(index - i) == str.charAt(index + i)){
                res = str.substring(index - i, index + i + 1);
            }else{
                break;
            }
        }
        return res;
    }

    static boolean areChareterUnique(String str)
    {
        int check=0;
        for(int i=0;i<str.length();i++)
        {
            int val=(str.charAt(i)-'a');
            System.out.println("val1:"+val);
            if((check&(1<<val))>0){
                System.out.println("check1:"+check);
                //将val放到check中对应的位置
                //如果有重复则返回FALSE
                return false;
            }
            check|=(1<<val);
            System.out.println("val2:"+(1<<val));
            System.out.println("check2:"+check);
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "abbasg";
        //str.substring(0,1);
        //str.substring(0,1);
//        System.out.println(str);
//        System.out.println("结果是："+longestPalindrome(str));
        System.out.println(areChareterUnique(str));
    }
}
