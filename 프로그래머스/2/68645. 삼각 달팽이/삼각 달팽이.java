class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];    // 등차수열의 합
        int[][] arr = new int[n][n];            // 그래프

        // 값을 넣고 싶은 인덱스
        int x = -1;
        int y = 0;
        int num = 1;

        // 이중 반복문
        // 6 -> 5 -> 4 -> 3 -> 2 -> 1 번 수행하기 위함
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {

                // 왼쪽 -> 바닥 -> 오른쪽 -> .. 반복됨
                // i=0 -> i=1 -> i=2 -> .. 반복되어 아래와 같이 조건문으로 접근 가능

                // 대각선 왼쪽
                if(i % 3 == 0) {
                    x++;
                    
                // 바닥
                } else if(i % 3 == 1) {
                    y++;

                // 대각선 오른쪽
                } else {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }

        // 정답 배열에 접근할 인덱스
        int idx = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] == 0) break;   // 0인 경우 반복문 빠져나감
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }

}