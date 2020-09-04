package string;

import java.awt.*;
import java.util.*;

public class 华为笔试明日之星 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        if(str.length < 0 || str.length > 100){
            System.out.println("error.0001");
        }else{
            HashMap<String, Integer> map = new HashMap();
            for (int i = 0; i < str.length; i++) {
                if(map.containsKey(str[i])){
                    map.put(str[i], map.get(str[i]) + 1);
                }else{
                    map.put(str[i], 1);
                }
            }

            int count = 0;
            ArrayList<String> list = new ArrayList<>();
            for (Map.Entry<String,Integer> entry:map.entrySet()) {
                if(entry.getValue() > count){
                    list.clear();
                    list.add(entry.getKey());
                    count = entry.getValue();
                }else if(entry.getValue() == count){
                    list.add(entry.getKey());
                }
            }
            if(list.size() == 1){
                System.out.println(list.get(0));
            }else{
                int index = 0;
                String res = "";
                for (int i = 1; i < list.size(); i++) {

                    if(list.get(index).length() < list.get(i).length()){
                        for(int j = 0; j < list.get(index).length();j++){
                            int a = list.get(index).charAt(j) - 'a';
                            int b = list.get(i).charAt(j) - 'a';
                            if(a < b){
                                res = list.get(index);
                                break;
                            }else if(a > b){
                                res = list.get(i);
                                index = i;
                                break;
                            }
                        }
                        res = list.get(index);
                    }else if(list.get(index).length() > list.get(i).length()){

                        for(int j = 0; j < list.get(i).length();j++){
                            int a = list.get(index).charAt(j) - 'a';
                            int b = list.get(i).charAt(j) - 'a';
                            if(a < b){
                                res = list.get(index);
                                break;
                            }else if(a > b){
                                res = list.get(i);
                                index = i;
                                break;
                            }
                        }

                        res = list.get(i);
                        index = i;

                    }else{
                        for(int j = 0; j < list.get(i).length();j++){
                            int a = list.get(index).charAt(j) - 'a';
                            int b = list.get(i).charAt(j) - 'a';
                            if(a < b){
                                res = list.get(index);
                                break;
                            }else if(a > b){
                                res = list.get(i);
                                index = i;
                                break;
                            }
                        }
                    }
                }
                System.out.println(res);
            }

        }

    }



}
