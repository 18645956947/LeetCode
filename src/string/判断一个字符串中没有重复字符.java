package string;

/**
 * ���������������ݽṹ �ж��ַ����Ƿ����ظ�Ԫ��
 * ����һ��λ���� һ��int ���Դ���4���ֽڣ�Ҳ����32������λ
 * @author zhx
 *
 * */
public class �ж�һ���ַ�����û���ظ��ַ� {

    public static boolean isUnique(String astr) {
        int a = 0;
        for(int i = 0;i < astr.length();i++){
            int index = astr.charAt(i) - 'a';
            if((a & (1<<index)) > 0){
                return false;
            }
            a |= 1<<index;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcsss"));
    }
}
