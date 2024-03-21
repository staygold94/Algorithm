class Solution {
    public boolean[] visited;
    public int answer = 50;
    public int solution(String begin, String target, String[] words) {

        // 초기화 (단어는 최대 50개이고 위치를 저장)
        visited = new boolean[50];
        
        // 너비 탐색 시작
        bfs(begin, target, words, 0);
        
        return answer == 50 ? 0 : answer;
    }

    public void bfs(String begin, String target, String[] words, int depth) {

        // 깊이가 넘어가면 리턴
        if(depth >= answer) return;

        // target이 만들어지면
        if(begin.equals(target)) {
            // 현재 depth와 answer 중에 작은 값을 answer에 넣는다.
            answer = Math.min(answer, depth);
        }
        
        // 현재 단어 begin을 가지고 words를 순회하며 글자가 한개만 다른 걸 찾는다.
        for(int i=0; i<words.length; i++) {
            // 방문하지 않았고, 글자가 한개만 다른 경우
            if(!visited[i] && isTarget(begin, words[i])) {
                visited[i] = true;                      // 방문처리
                bfs(words[i], target, words, depth+1);  // 재귀 순회
                visited[i] = false;                     // 재귀 종료되어 다시 돌아오면 false 처리 해준다 !!
            }
        }
    
        return;
    }

    public boolean isTarget(String a, String b) {
        int cnt = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1 ? true : false;
    }
}