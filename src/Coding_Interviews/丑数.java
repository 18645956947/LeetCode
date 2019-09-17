package Coding_Interviews;

/**
 * 剑指offer -- 丑数
 * @author zhx
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7){
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i = 1;
        for(i = 1;i < index;i++){
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5]*5));
            if(res[i] == res[t2] * 2){
                t2++;
            }
            if(res[i] == res[t3] * 3) t3++;
            if(res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        丑数 s = new 丑数();
        int a = s.GetUglyNumber_Solution(16);
        System.out.println(a);
    }
}
