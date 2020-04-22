package 剑指offer.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 坐船问题 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] str1 = a.split(" ");
        int[] weights = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            weights[i] = Integer.parseInt(str1[i]);
        }
        int maxLoad = Integer.parseInt(br.readLine());

        int count = countLeastBoat(weights, maxLoad);
       /* int[] weights = new int[]{80, 90};
        int maxLoad = 100;*/
        System.out.println(count);
    }
    public static int countLeastBoat(int[] weight, int maxLoad){
        Arrays.sort(weight);
        if(maxLoad - weight[0] < 0){
            return 0;
        }
        int count = 1;
        int cur = 1;
        int res = maxLoad - weight[0];
        for (int i = 1; i < weight.length; i++) {

            if(res >= weight[i]){
                res -= weight[i];
            }else{
                count++;
            }
        }
        return count;

    }
}
