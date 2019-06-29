package oa.imc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Battleship_Games {

    public String solution(int N, String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) return "0, 0";
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> ships = new HashMap<>();
        for (String str : S.split(",")) {
            String[] pair = str.split(" ");
            String tl = pair[0];
            String br = pair[1];
            int il = Integer.valueOf(tl.substring(0, tl.length() - 1));
            int jl = tl.charAt(tl.length() - 1) - 'A';
            int ih = Integer.valueOf(br.substring(0, br.length() - 1));
            int jh = br.charAt(br.length() - 1) - 'A';
            int shipID = il * N + jl;
            for (int i = il; i <= ih; i++) {
                for (int j = jl; j <= jh; j++) {
                    int positionID = i * N + j;
                    map.put(positionID, shipID);
                    ships.computeIfAbsent(shipID, k -> new HashSet<>());
                    ships.get(shipID).add(positionID);
                }
            }
        }

        Set<Integer> hit = new HashSet<>();
        Set<Integer> sunk = new HashSet<>();
        for (String str : T.split(" ")) {
            int i = Integer.valueOf(str.substring(0, str.length() - 1));
            int j = str.charAt(str.length() - 1) - 'A';
            int positionID = i * N + j;
            if (!map.containsKey(positionID)) continue;
            int shipID = map.get(positionID);
            if (ships.get(shipID).remove(positionID)) {
                hit.add(shipID);
            }
            if (ships.get(shipID).size() == 0) {
                sunk.add(shipID);
            }
        }
        return String.format("%d,%d", sunk.size(), hit.size() - sunk.size());
    }

}
