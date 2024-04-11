class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        // 곱셈을 담을 행렬의 크기(mxn)
        int m = arr1.length;
        int n = arr2[1].length;
        int[][] answer = new int[m][n];

        // 정답 행렬의 크기만큼 이중반복문 수행
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // arr1의 열의 갯수 == arr2의 행의 갯수
                // 이 갯수만큼 매칭해서 곱해줌
                for(int k=0; k<arr1[1].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}