package string; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:23:14 
* @Description: 72. 编辑距离
*/
public class MinDistance {
	public  int minDistance(String word1, String word2) {
		int[][] d = new int [word1.length() + 1][word2.length() + 1];
       if(Math.min(word1.length(), word2.length()) == 0){
           return Math.max(word1.length(), word2.length());
       }
		//行赋值
		for(int i = 0;i<=word1.length();i++) {
			d[i][0] = i;
		}
		//列赋值
		for(int j = 0;j<=word2.length();j++) {
			d[0][j] = j;
		}
		for(int i = 1;i<=word1.length();i++) {
			for(int j = 1;j<=word2.length();j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					d[i][j] = d[i-1][j-1];
				}
				else {
					d[i][j] = Math.min(d[i-1][j], 
							Math.min(d[i][j-1], d[i-1][j-1])) + 1;
				}
			}
			
		}
		return d[word1.length()][word2.length()];
	}
}
 