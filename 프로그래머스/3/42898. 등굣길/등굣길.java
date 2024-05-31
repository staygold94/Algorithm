class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] arr = new int[m][n];

        // 초기화
        arr[0][0] = 1;
        
        // 물웅덩이 -1로 초기화
        for(int i=0; i<puddles.length; i++) {
            arr[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // 물웅덩이로 갈 수 있는 방법은 0개
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                    continue;
                }

                // 위에서 오는 것과 오른쪽에서 오는 방법을 더한다
                if(i != 0) arr[i][j] += arr[i-1][j] % 1000000007;
                if(j != 0) arr[i][j] += arr[i][j-1] % 1000000007;
            }
        }

        return arr[m-1][n-1] % 1000000007;
    }
}