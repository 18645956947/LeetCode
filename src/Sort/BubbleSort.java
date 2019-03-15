package Sort;

/**
 * @author lenovo
 * @date 2019Äê3ÔÂ14ÈÕÏÂÎç10:32:58
 * @Description:
 */
public class BubbleSort {
	// Ã°ÅİÅÅĞò
	public static int[] bubbleSort(int[] sum) {
		int tem = 0;
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = 0; j < sum.length - 1 - i; j++) {
				if (sum[j] > sum[j + 1]) {
					tem = sum[j + 1];
					sum[j + 1] = sum[j];
					sum[j] = tem;
				}
			}
		}
		return sum;
	}
	
	  //Ã°ÅİÅÅĞò
	 public static void main(String[] args) {
		 int[] sum = new int[] {3,2,1,4};
		 for(int i = 0;i<sum.length;i++) {
			  System.out.print(sum[i]); 
		 }
		 System.out.println("----");
		 bubbleSort(sum);
		 for(int i = 0;i<sum.length;i++) {
			 System.out.print(sum[i]);
		 }
	 }
}
