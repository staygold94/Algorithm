import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        int idx = 0;    // substring 시작점 idx (answer에 들어가지 않은 위치 저장)
        HashMap<String, Integer> map = new HashMap<>();

        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven",7);
        map.put("eight", 8);
        map.put("nine", 9);
        

        for(int i=0; i<s.length(); i++) {
            // 숫자인 경우
            if(Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
                idx = i+1;
            // 문자인 경우
            } else {
                String str = s.substring(idx, i+1);
                // map에 저장된 문자열인 경우
                if(map.containsKey(str)) {
                    answer += map.get(str);
                    idx = i+1;
                }
            }
        }
        return Integer.parseInt(answer);
    }
}