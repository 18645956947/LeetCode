package Array; 

/** 
* @author lenovo
* @date 2019年3月15日下午1:52:01 
* @Description: 66. 加一
* 
*/
public class PlusOne {
	public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i=0;i<res.length;i++) {
        	System.out.println(res[i]);
        }
        return res;
    }
	public static void main(String[] args) {
		PlusOne s1 = new PlusOne();
		int[] num = new int[] {4,3,2,1};
		s1.plusOne(num);

	}

}
 