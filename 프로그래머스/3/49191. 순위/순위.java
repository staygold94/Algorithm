class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] match = new int[n][n];

        // 기본 세팅
        for(int[] result : results){
            int winner = result[0] - 1;
            int loser = result[1] - 1;
            match[winner][loser] = 1;     // win
            match[loser][winner] = -1;    // lose
        }

        // a->b 이고 b->c이면 a->c 인 경우
        for(int b=0; b<n; b++) {
            for(int a=0; a<n; a++) {
                // 진 경우는 제외
                if(match[a][b] <= 0) {
                    continue;
                }

                // 이긴 경우 (a->b)
                for(int c=0; c<n; c++) {
                    // b->c인 경우, 그리고 a와 c의 관계를 알 수 없는 경우
                    if(match[b][c] > 0 && match[a][c] == 0) {
                        match[a][c] = 1;
                        match[c][a] = -1;
                    }
                }
            }
        }

        for(int i=0; i<match.length; i++) {
            int cnt = 0;
            for(int j=0; j<match[i].length; j++) {
                if(match[i][j] != 0) cnt++;
            }
            // n에서 자기 자신을 제외하고 (-1) 값이 있는 경우 순위를 알 수 있음
            if(cnt == n - 1) answer++;
        }   

        return answer;
    }
}