package Coding_Interviews;

/**
 * ��ָoffer -- �����˻�����
 * @author
 * zhx
 */
public class �����˻����� {

    public int[] multiply(int[] A) {
        int k = 1;
        int[] res = new int[A.length];

        for(int i = 0;i < A.length;i++){
            res[i] = k;   // res[i]�洢����i��ߵĳ˻�
            k = k*A[i];
        }
        k = 1;
        for(int i = A.length-1;i>=0;i--){
            res[i] *= k; // kΪi�ұߵĳ˻�   res[i]�洢����i��ߵĳ˻�*�ұߵĳ˻�
            k = k*A[i]; // kΪi�ұߵĳ˻�
        }
        return res;
    }
}
