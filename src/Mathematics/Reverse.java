package Mathematics;

import zhx.day1216.Solution1;

/** 
* @author zhx
* @date 2019��3��15������1:38:58 
* @Description: 7. ������ת
*/
public class Reverse {
	public int reverse(int x) {
	       long x1 = 0L;
			while(x != 0){
				x1 = x1 * 10 + x % 10;
				x /= 10;
			}
			return x1 == (int) x1 ? (int) x1 :  0;
	}
	public static void main(String[] args) {
		Reverse s1 = new Reverse();
		int num = -123456789;
		System.out.println(s1.reverse(num));
	}
}
 