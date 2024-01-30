import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;  // 기본값

        Set<String> set = new HashSet<>();
        for(String s : phone_book) {
            set.add(s);
        }

        // 자른 문자열이 다른 번호와 동일한지 확인 (접두어인지)
        for(int i=0; i<phone_book.length; i++) {
            for(int j=1; j<phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0,j))) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}