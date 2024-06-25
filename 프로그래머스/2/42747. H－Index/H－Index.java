import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;;

        // 오름차순 정렬
        Arrays.sort(citations);

        for(int i=1; i<=len; i++) {
            if(i <= citations[len-i]) answer = i;
            else break;
            System.out.println(citations[len-i]);
        }

        return answer;
    }
}