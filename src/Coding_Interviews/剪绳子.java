package Coding_Interviews;


/**
 * ��ָoffer -- ������
 * @author zhx
 */
public class ������ {

    public int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int a = target % 3;
        int b = target / 3;
        if(a == 0){
            return (int) Math.pow(3, b);
        }else if(a == 1){
            return 2 * 2 * (int) Math.pow(3, b - 1);
        }else{
            return 2 * (int) Math.pow(3, b);
        }
    }
}
