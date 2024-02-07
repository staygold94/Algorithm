import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        // 변수로 들어온 배열 크기만큼 정답 배열 선언
        int[] answer = new int[emergency.length];

        // Integer 배열로 변환하여 내림차순 정렬
        Integer[] arr = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> b - a);

        // 내림차순 정렬된 응급도와 동일한 경우 해당 인덱스 반환 (0번째는 없으므로 +1 해준다)
        for(int i=0; i<emergency.length; i++) {
            int idx = 0;
            for(int j=0; j<arr.length; j++) {
                if(emergency[i] == arr[j]) idx = j+1;
            }
            answer[i] = idx;
        }

        return answer;
    }
}