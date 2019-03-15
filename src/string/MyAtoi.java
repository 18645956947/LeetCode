package string; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:12:26 
* @Description: 8. 字符串转换整数 (atoi)
* 
*/
public class MyAtoi {
	public int myAtoi(String str) {
		//判断第一个整数元素下标
		int index = 0;
		//正数为1 负数为-1
		int flag = 1;
		//转换后的数字
		int base = 0;
		//判断数字是否为空
		if (str.isEmpty()) return 0;
		while(index<str.length() && str.charAt(index) == ' ') {
			index++;
		}
		if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
			if(str.charAt(index) == '+') {
				flag = 1;
				index++;
			}
			else {
				flag = -1;
				index++;
			}
		
		while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			// 溢出判断，MAX_VALUE的个位为7
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7))
                if (flag == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            //char-'0' 变成Int 类型
			base = base * 10 + str.charAt(index++) - '0';
		}
		return base * flag;
	}
}
 