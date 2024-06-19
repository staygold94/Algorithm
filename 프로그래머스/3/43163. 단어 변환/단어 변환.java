class Solution {
    public boolean[] visited;
    public int answer;
    public int solution(String begin, String target, String[] words) {

        // 초기화
        answer = 0;
        visited = new boolean[words.length];

        // dfs
        dfs(begin, target, words, 0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words, int depth) {
        if(begin.equals(target)) {
            answer = depth;
            return;
        }

        for(int i=0; i<words.length; i++) {
            // 방문하지 않았고, 1개의 차이가 난다면
            if(!visited[i] && isTarget(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth+1);
                visited[i] = false;
            }
        }
    }

    public boolean isTarget(String a, String b) {
        
        // 길이가 다른 경우 false 반환
        if(a.length() != b.length()) {
            return false;
        }

        // 한개의 문자만 다른지 확인
        int cnt = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }

        return true;
    }
}