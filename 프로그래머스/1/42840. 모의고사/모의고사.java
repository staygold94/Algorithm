import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList();
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        for(int i=0; i<answers.length; i++) {
            cnt[0] += p1[i%5] == answers[i] ? 1 : 0;
            cnt[1] += p2[i%8] == answers[i] ? 1 : 0;
            cnt[2] += p3[i%10] == answers[i] ? 1 : 0;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i] == max) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}