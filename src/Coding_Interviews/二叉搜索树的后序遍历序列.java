package Coding_Interviews;

/**
 * ��ָoffer---�����������ĺ����������
 * @author zhx
 */
public class �����������ĺ���������� {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length <= 0){
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if(start >= end){
            return true;
        }
        //�������������һ���ڵ���Ǹ��ڵ�
        int root = sequence[end];
        int i = start;
        //i��ߵĳ��˸��ڵ����������  i�ұߵİ���i����������
        while(sequence[i] < root){
            i++;
        }

        //�ú����������ж���������ÿһ��ֵ�Ƿ�ȸ��ڵ��
        for(int j = i;j < end;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        //�ж��������Ƿ�Ϊһ����������Ķ���������
        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        //�ж��������Ƿ�Ϊһ����������Ķ���������
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;

    }
}
