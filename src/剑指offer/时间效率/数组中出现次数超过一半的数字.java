package 剑指offer.时间效率;

/**
 * 剑指offer - 数组中出现次数超过一半的数字
 * @author zhx
 */
public class 数组中出现次数超过一半的数字 {
    //时间复杂度O（N）
    //采用数组的方式，相同的数就加一，不相同就减一，减到零就重新赋值
    //然后判断最后的数是否是大于数组长度的一半
    public int MoreThanHalfNum_Solution(int [] array) {
        if(!check(array, array.length)){
            return 0;
        }
        int time = 1;
        int res = array[0];
        for(int i = 1;i < array.length;i++){
            if(time == 0){
                res = array[i];
                time++;
            }else if(res == array[i]){
                time++;
            }else{
                time--;
            }
        }
        if(checkMore(array, array.length,res)){
            return res;
        }
        return 0;
    }
    private boolean checkMore(int[] array, int len, int result){
        int num = 0;
        for(int i = 0;i < len;i++){
            if(array[i] == result){
                num++;
            }
        }
        if(num > len / 2){
            return true;
        }
        return false;
    }

    private boolean check(int[] array,int len){
        if(array == null || len == 0){
            return false;
        }
        return true;
    }
}
