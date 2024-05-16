import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings;

        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int result = Integer.compare(a.charAt(n), b.charAt(n));
                if(result != 0) {
                    return result;
                }
                return a.compareTo(b);
            }
        });

        return answer;
    }
}