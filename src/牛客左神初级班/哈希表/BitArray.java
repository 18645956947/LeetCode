package ţ�����������.��ϣ��;

/**
 * ����������һ����¡������
 * �����Լ�Ҫʵ��һ����������
 * @author zhx
 */
public class BitArray {

    public static void main(String[] args) {
        int[] arr = new int[1000]; // һ��Int��ʾ�ĸ��ֽڣ�һ���ֽڱ�ʾ8��bitλ 1000��int ��ʾ32000bitλ
        //��¡������ ��ѵ�30000��λ�����
        int index = 30000;
        //������ƽ�ֳ�1000��Ҳ����0~999�� �����ж������ĸ�0~999���ĸ�λ�ã��ҳ�ΪͰ
        int intIndex = index / 32;
        System.out.println(intIndex);
        //�������ǰ����Ͱ�µ��ĸ�bitλ���
        int bitIndex = index % 32;
        System.out.println(bitIndex);
        //1 << bitIndex ��ʾ�ѵ�bitIndexλ�õ�����0���1 ��Ȼ����֮ǰ������һ���������
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}
