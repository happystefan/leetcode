package Y2020.linkedin.algo_part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q012_Insert_Delete_GetRandom_O_1 {

    class solution_two_map {

        class DS<T> {
            Map<Integer, T> map = new HashMap<>();
            Map<T, Integer> rmap = new HashMap<>();

            public boolean add(T ele) {
                if (rmap.containsKey(ele)) return false;
                int idx = rmap.size() - 1;
                map.put(idx, ele);
                rmap.put(ele, idx);
                return true;
            }

            public boolean remove(T ele) {
                if (!rmap.containsKey(ele)) return false;
                int idx = rmap.get(ele);
                rmap.remove(ele);
                map.remove(idx);
                return true;
            }

            public T removeRandom() {
                if (map.isEmpty()) return null;
                int idx = new Random().nextInt(rmap.size());
                T ele = map.get(idx);
                map.remove(idx);
                rmap.remove(ele);
                return ele;
            }
        }

    }

    class solution_map_and_array {

        class DS<T> {
            Map<T, Integer> map = new HashMap<>();
            ArrayList<T> list = new ArrayList<>();

            public boolean add(T ele) {
                if (map.containsKey(ele)) return false;
                map.put(ele, list.size());
                list.add(ele);
                return true;
            }

            public boolean remove(T ele) {
                if (!map.containsKey(ele)) return false;
                int idx = map.get(ele);
                if (idx < list.size() - 1) {
                    T last = list.get(list.size() - 1);
                    map.put(last, idx);
                    list.set(idx, last);
                }
                list.remove(list.size()-1);
                map.remove(ele);
                return true;
            }

            public T removeRandom() {
                int idx = new Random().nextInt(list.size());
                T ele  = list.get(idx);
                remove(ele);
                return ele;
            }
        }

    }
}
