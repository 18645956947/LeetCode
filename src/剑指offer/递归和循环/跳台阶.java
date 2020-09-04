package 剑指offer.递归和循环;

/**
 * 剑指offer - 跳台阶
 * @author zhx
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target - 1)+JumpFloor(target - 2);
    }
}
