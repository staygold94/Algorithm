class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quard(arr, 0, 0, arr.length); // 쿼드 트리 알고리즘을 호출하여 압축 수행
        return answer; // 결과 반환
    }

    // 주어진 영역이 압축 가능한지 여부를 판단하는 함수
    public boolean zip(int[][] arr, int x, int y, int len) {
        int pointer = arr[x][y];

        // 영역 내의 모든 값이 같은지 확인하여 압축 가능 여부 판단
        for(int i=x; i<x+len; i++) {
            for(int j=y; j<y+len; j++) {
                if(pointer != arr[i][j]) return false; // 값이 다르면 압축 불가능
            }
        }
        return true; // 모든 값이 같으면 압축 가능
    }

    // 이미지를 재귀적으로 분할하여 쿼드 트리 압축을 수행하는 함수
    public void quard(int[][] arr, int x, int y, int len) {

        // 압축할 수 있다면
        if(zip(arr, x, y, len)) {
            if(arr[x][y] == 0) answer[0]++;     // 압축 가능하고 0인 경우 0의 개수 증가
            else answer[1]++;                   // 압축 가능하고 1인 경우 1의 개수 증가
            return;                             // 현재 영역은 더 이상 분할할 필요 없음

        // 압축할 수 없다면 잘라서 다시 압축 시도
        } else {
            quard(arr, x, y, len/2);            // 왼쪽 위 사분면
            quard(arr, x, y+len/2, len/2);      // 오른쪽 위 사분면
            quard(arr, x+len/2, y, len/2);      // 왼쪽 아래 사분면
            quard(arr, x+len/2, y+len/2, len/2);// 오른쪽 아래 사분면
        }
    }
}