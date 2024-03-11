import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0; // 보트 나르는 횟수
        int idx = 0;    // 가벼운 사람 인덱스

        // 몸무게 오름차순 정렬
        Arrays.sort(people);

        // 무거운 사람부터 인덱스 사람까지 반복문을 돈다.
        for(int i=people.length-1; i>=idx; i--) {
            // 가장 가벼운 사람 + 무거운 사람 조합 <= 무게제한 이라면
            // 둘다 나르고, idx 값을 변경한다.
            if(people[i] + people[idx] <= limit) {
                answer++;
                idx++;

            // 무게를 초과한다면 무거운 사람만 나른다.
            } else {
                answer++;   // 보트 나르는 횟수 증감
            }
        }

        // 배에 현재 실린 사람이 있다면 증감하여 리턴
        return answer;
    }
}