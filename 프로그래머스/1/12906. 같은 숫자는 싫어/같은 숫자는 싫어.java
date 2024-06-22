import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            // 이전 숫자와 연속되는 경우 continue;
            if(list.size() > 0) {
                int num = list.get(list.size()-1);
                if(arr[i] == num) {
                    continue;
                }
            }
            list.add(arr[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}