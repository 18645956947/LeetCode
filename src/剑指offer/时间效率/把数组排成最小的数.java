package 剑指offer.时间效率;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int a:numbers) {
            list.add(a);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        String s = "";
        for (int a:list) {
            s += a;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 32, 321};
//        System.out.println(把数组排成最小的数.PrintMinNumber(a));
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        String s1 = "a";
        String s2 = "bc";
        String s3 = "ab";
        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s3));
        System.out.println(s3.compareTo(s2));
        ArrayList<Integer> res = new ArrayList<>();
        Integer dd = new Integer(1);
        Integer dd1= new Integer(2);
        res.add(new Integer(1));
        res.add(new Integer(2));
        System.out.println(res.contains(1));
        res.remove(dd);
        System.out.println(res);
        String sss = "abc";
        System.out.println(sss.indexOf("a"));
    }
}
