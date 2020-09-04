package string;

public class ×Ö·û´®×ªÕûÊý {
    public  static int myAtoi(String str) {
        if(str == null || str.length() == 0 || str.trim().equals("")){
            return 0;
        }
        String s = str.trim();
        int f = 1;
        int start = 0;
        if(s.charAt(0) == '-'){
            start = 1;
            f = -1;
        }else if(s.charAt(0) == '+'){
            start = 1;
        }else if(s.charAt(0) < '0' || s.charAt(0) > '9'){
            return 0;
        }
        int res = 0;
        int max = Integer.MAX_VALUE/10;

        for(int i = start;i < s.length();i++){

            char c = s.charAt(i);
            if(c <'0' || c > '9'){
                return res * f;
            }
            if(res > max || res == max && c > '7'){
                if(f == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }

            res = res * 10 + c - '0';
        }
        return res * f;
    }
    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
