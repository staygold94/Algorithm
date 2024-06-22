import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종류별로 카운트
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 입을 수 있는 종류 = (종류별 카운트 + 1) * (종류별 카운트 + 1) * ... - 1 (아예 안 입는 경우 빼기)
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}