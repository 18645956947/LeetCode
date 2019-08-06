package Array;

/**
 * 739. 每日温度
 * @author zhx
 */
public class DailyTemperatures {

    //500+ms  时间复杂度O（N^2）
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if(T.length == 0 || T == null){
            return res;
        }
        for(int i = 0;i < T.length;i++){
            int sum = 1;
            for(int j = i+1;j<T.length;j++){
                if(T[j] <= T[i]){
                    sum++;
                    if(j == T.length-1 && sum == 0){
                        res[i] =0;
                    }
                }
                else{
                    res[i] = sum;
                    break;
                }
            }
        }
        res[T.length-1] = 0;
        return res;
    }
    //8ms
    public int[] dailyTemperatures_02(int[] T) {
        int[] res = new int[T.length];
        if(T.length == 0 || T == null){
            return res;
        }
        for(int i = T.length-2;i >= 0;i--){
            for(int j = i+1;j<T.length;j += res[j]){
                if(T[j] > T[i]){
                    res[i] = j-i;
                    break;
                }
                else if(res[j] == 0){
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

}
