package List;

import java.util.ArrayList;

/**
 * ��һ����ά���� [[a,b], [c,d], [d, e], [f, q]] ���� e ����[a, d, c]
 */
public class �������� {
    ArrayList<ArrayList<String>> rel = new ArrayList<>();
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> findRel(String str){
        if(str == ""){
            return res;
        }
        for (int i = 0; i < rel.size(); i++) {
            if(str == rel.get(i).get(1)){
                res.add(rel.get(i).get(0));
                findRel(rel.get(i).get(0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        �������� a = new ��������();
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("A");
        a1.add("B");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("B");
        a2.add("C");
        ArrayList<String> a3 = new ArrayList<>();
        a3.add("C");
        a3.add("D");
        ArrayList<String> a4 = new ArrayList<>();
        a4.add("E");
        a4.add("F");
        a.rel.add(new ArrayList<>(a1));
        a.rel.add(new ArrayList<>(a2));
        a.rel.add(new ArrayList<>(a3));
        a.rel.add(new ArrayList<>(a4));
        System.out.println(a.rel);
        System.out.println("���룺D");
        System.out.println(a.findRel("F"));

    }
}
