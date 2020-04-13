package string;

import java.util.ArrayList;

public class N进制完美数 {

    public static ArrayList<Integer> GetPowerFactor (int R, int N) {
        int num = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        while (R > 0 ){
            int mod = R % N;
            if(mod == 1){
                res.add(count);
            }
            if(mod >= 2){
                return null;
            }
            R = R/3;
            num++;
        }
        return res;

    }

}
