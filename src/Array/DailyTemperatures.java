package Array;

/**
 * 739. Ã¿ÈÕÎÂ¶È
 * @author zhx
 */
public class DailyTemperatures {
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
}
