class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n][n];

        // 이긴 관계는 1, 진 관계는 -1로 표시 (관계를 알 수 없는 경우 기본값 0)
        for(int[] result : results) {
            arr[result[0]-1][result[1]-1] = 1;
            arr[result[1]-1][result[0]-1] = -1;
        }

        // a -> b 이고 b -> c 이면, a -> c다
        for(int k=0; k<arr.length; k++) {
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr.length; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
                    if(arr[i][k] == -1 && arr[k][j] == -1) arr[i][j] = -1;
                }
            }
        }

        // 관계를 모두 알 수 있는 경우 answer++
        for(int i=0; i<arr.length; i++) {
            int count = 0;
            for(int j=0; j<arr.length; j++) {
                if(i == j || arr[i][j] != 0) count++;
            }
            if(count == n) answer++;
        }

        return answer;
    }
}