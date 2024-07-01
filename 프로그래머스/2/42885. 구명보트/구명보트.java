import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        
        while(left <= right) {
            int total = 0;
            total += people[right];
            right--;
            
            if(left <= right && total + people[left] <= limit) {
                left++;
            }
            answer++;
        }

        return answer;
    }
}