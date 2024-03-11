import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0; // 보트 나르는 횟수
        int idx = 0; // 실어야 하는 사람 인덱스

        // 몸무게 오름차순 정렬
        Arrays.sort(people);
        int sum = 0;

        // 가벼운 사람부터 마지막 사람까지 반복문을 돈다.
        while(idx < people.length) {
            // 배에 탈 수 있다면
            if(people[idx] <= limit - sum) {
                sum += people[idx]; // 현재 무게 추가
                idx++;              // 다음 사람 인덱스

            // 배에 탈 수 없다면
            } else {
                answer++;   // 보트 나르는 횟수 증감
                sum = 0;    // 현재 무게 초기화
            }
        }

        // 배에 현재 실린 사람이 있다면 증감하여 리턴
        return sum == 0 ? answer : ++answer;
    }
}