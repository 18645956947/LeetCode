package 牛客左神初级班.哈希表;

/**
 * 这里是想做一个布隆过滤器
 * 首先自己要实现一个比特数组
 * @author zhx
 */
public class BitArray {

    public static void main(String[] args) {
        int[] arr = new int[1000]; // 一个Int表示四个字节，一个字节表示8个bit位 1000个int 表示32000bit位
        //布隆过滤器 想把第30000的位置描黑
        int index = 30000;
        //把数组平分成1000个也就是0~999， 首先判断落在哪个0~999的哪个位置，我称为桶
        int intIndex = index / 32;
        System.out.println(intIndex);
        //描述的是把这个桶下的哪个bit位描黑
        int bitIndex = index % 32;
        System.out.println(bitIndex);
        //1 << bitIndex 表示把第bitIndex位置的数从0变成1 ，然后与之前的数做一个或的运算
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}
