import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        // 종류별로 옷 개수 카운트
        for(int i=0; i<clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        // 입지 않음을 포함하여 곱함(cross)
        for(String s:map.keySet()) {
            answer *= map.get(s) + 1;
        }

        // 종류가 3개라면 입지 않음 + 입지 않음 + 입지않음 조합을 고려하여 -1 해준다.
        return answer-1;
    }
}