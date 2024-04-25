import java.util.*;

class Solution {
    List<String> list;
    public int solution(String word) {
        String[] arr = {"A", "E", "I", "O", "U"};
        list = new ArrayList<>();

        // 완전탐색 하여 사전 구성
        for(int i=0; i<arr.length; i++) {
            dfs(arr, arr[i], 0);    // 단어의 구성이 dfs에 가까운 형태이므로 dfs로 해결
        }

        // 주어진 word 순서를 리턴하는 함수 indexOf 사용
        return list.indexOf(word) + 1;
    }

    public void dfs(String[] arr, String str, int depth) {

        // 5글자를 넘어가면 return
        if(depth == 5) return;
        list.add(str);  // 사전 추가

        // 깊이우선탐색하여 글자를 쌓아간다
        for(int i=0; i<arr.length; i++) {
            dfs(arr, str + arr[i], depth+1);
        }
    }
}