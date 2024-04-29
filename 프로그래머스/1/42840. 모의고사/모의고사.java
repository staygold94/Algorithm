import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 정답과 일치하는 경우 정답개수 +1함
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%one.length]) cnt[0]++;
            if(answers[i] == two[i%two.length]) cnt[1]++;
            if(answers[i] == three[i%three.length]) cnt[2]++;
        }

        // 고득점
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        ArrayList<Integer> list = new ArrayList<>();
        // 고득점을 맞은 경우 리스트에 넣음
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i] == max) list.add(i+1);
        }

        // 정답 반환을 위해 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}