package oa.linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Custom_Sort {

    static void customSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) map.put(val, map.getOrDefault(val, 0) + 1);
        Integer[] list = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(list, (a, b) -> map.get(a).intValue() == map.get(b).intValue() ? a - b : map.get(a) - map.get(b));
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

}
