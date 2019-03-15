package Dynamic_Programming; 

/** 
* @author lenovo
* @date 2019年3月15日下午2:38:29 
* @Description: 121. 买卖股票的最佳时机
*/
public class MaxProfit {
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrices = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){
           if(prices[i] < minPrices){
               minPrices = prices[i];
           }else if(prices[i] - minPrices > maxProfit){
               maxProfit = prices[i] - minPrices;
           }
        }
        return maxProfit;
    }
}
 