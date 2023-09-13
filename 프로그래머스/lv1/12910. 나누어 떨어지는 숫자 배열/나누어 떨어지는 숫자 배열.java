import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> arrayList = new ArrayList<>();
        
        // 나누어 떨어지는 값 arrayList에 add
        for(Integer num : arr) {
           if(num % divisor == 0) arrayList.add(num); 
        }
        
        // 값이 하나도 없는 경우 -1 add
        if(arrayList.size() == 0)
            arrayList.add(-1);
        
        // 정렬
        Collections.sort(arrayList);
        
        // int[]로 변환하여 return
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /*
    // 인상 깊었던 답안
    public int[] solution2(int[] arr, int divisor) {
        // 스트림 처리 후 필터함수를 람다식으로 활용
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
    }
    */
}