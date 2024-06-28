import java.util.*;

class Solution {
    public String[] arr = {"A", "E", "I", "O", "U"};
    public List<String> list;
    public boolean found = false;   // 원하는 단어를 찾았는지 확인

    public int solution(String word) {
        // 모음사전 초기화
        list = new ArrayList<>();

        dfs(word, "");

        return list.size();
    }

    public void dfs(String word, String str) {

        if(found || arr.length < str.length()) {
            return;
        }

        // 빈값이 아닌 경우 list 에 str 추가
        if(!str.equals("")) {
            list.add(str);
            if(str.equals(word)) {
                found = true;
            }
        }

        for(int i=0; i<arr.length; i++) {
            dfs(word, str + arr[i]);
        }
        
    }
}