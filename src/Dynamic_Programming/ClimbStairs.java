package Dynamic_Programming; 

/** 
* @author lenovo
* @date 2019��3��15������2:37:14 
* @Description: 70. ��¥��
*/
public class ClimbStairs {
	 public int climbStairs(int n) {
	     if(n<1) {
	    	  return 0;
	     }
		 if(n == 1) {
			 return 1;
		 }
		 
		 if(n == 2) {
			 return 2;
		 }
		 int a = 1;
		 int b = 2;
		 int temp = 0;
		 for(int i = 3;i <= n;i++) {
			 temp = a+b;
			 a = b;
			 b = temp;
		 }
		 return temp;
	 }
}
 