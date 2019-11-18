package Coding_Interviews;

/**
 * 剑指offer - 矩形覆盖
 * 这种题就是自己画下图然后找规律
 * @author zhx
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return  1;
        }
        if(target == 2){
            return 2;
        }else{
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
