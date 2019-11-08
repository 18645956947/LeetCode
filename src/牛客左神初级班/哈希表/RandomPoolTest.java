package 牛客左神初级班.哈希表;


import java.util.HashMap;

/**
 * 设计一种结构--RandomPool：
 * 有三种功能：
 * （1）insert(key) 将某个key加入到该结构中，做到不重复加入
 * （2）delete(key)删除Key
 * (3)getRandom() 等概率的返回该结构中的任意一个key
 * 三个操作时间复杂度都是O(1)
 */
public class RandomPoolTest {

    public static class RandomPool<K>{
        private HashMap<K, Integer> map1;
        private HashMap<Integer, K> map2;
        private int size;
        public RandomPool(){
                map1 = new HashMap<>();
                map2 = new HashMap<>();
                this.size = 0;
        }
        public void insert(K str){
            if(!map1.containsKey(str)){
                this.map1.put(str, size);
                this.map2.put(size++, str);
            }
        }
        public void delete(K str){
            if(map1.containsKey(str)){
                int deleteIndex = map1.get(str);
                int lastIndex = --size;
                K lastKey = map2.get(lastIndex);
                this.map1.put(lastKey, deleteIndex);
                this.map2.put(deleteIndex, lastKey);
                this.map1.remove(lastKey);
                this.map2.remove(lastIndex);
            }
        }
        public K getRandom(){
            if(size == 0){
                return null;
            }
            int index = (int) (Math.random() * size);
            return this.map2.get(index);
        }
    }

    public static void main(String[] args) {
        RandomPool pool = new RandomPool();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }

}
