import java.util.*;

class Solution {
    public static ArrayList<String> list;

    public int solution(String word) {
        int answer = 0;
        String[] arr = {"A", "E", "I", "O", "U"};   // 준비된 단어
        list = new ArrayList<>();                   // 단어사전 초기화
        
        // 준비된 단어에 대해 재귀 호출하여 단어사전을 채운다.
        for(int i=0; i<arr.length; i++) {
            dfs(arr[i], arr, word);
        }

        // 일치하는 단어가 몇번째인지 찾는다.
        for(int i=0; i<list.size(); i++) {
            answer++;
            if(list.get(i).equals(word)) break;
        }

        return answer;
    }

    public static void dfs(String str, String[] arr, String word) {

        if(str.length() > 5) return;    // 모음의 최대갯수인 5자를 넘어가면 return
        list.add(str);                  // 그렇지 않은 경우 단어사전 add
        if(word.equals(str)) return;    // 만약 찾는 str을 발견시 dfs 종료

        for(int i=0; i<arr.length; i++) {
            dfs(str + arr[i], arr, word);   // 재귀 호출 하면서 단어사전을 채워간다.
        }
    }
}