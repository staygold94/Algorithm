import java.io.*;
import java.util.*;

public class Main {
    public static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new int[9][9];

        for(int i=0; i<9; i++) {
            answer[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if(dfs()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(answer[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.print(sb.toString());
        }
    }

    public static boolean dfs() {

        // 빈칸 찾기
        int[] arr = findEmptyCell();

        // 빈칸 없을시 true 반환
        if(arr == null) {
            return true;
        }

        int x = arr[0];
        int y = arr[1];

        boolean[] visited = new boolean[9];

        // 상하 줄 확인
        for(int i=0; i<9; i++) {
            if(answer[x][i] != 0) visited[answer[x][i]-1] = true;
            if(answer[i][y] != 0) visited[answer[i][y]-1] = true;
        }

        // 가까운 영역 확인
        // m과 n은 그리드의 시작 위치
        int m = (x / 3) * 3;
        int n = (y / 3) * 3;

        for(int i=m; i<m+3; i++) {
            for(int j=n; j<n+3; j++) {
                if(answer[i][j] != 0) visited[answer[i][j]-1] = true;
            }
        }

        // 입력 가능한 숫자 넣어보기
        for(int i=1; i<=9; i++) {
            if(!visited[i-1]) {
                answer[x][y] = i;
                if(dfs()) return true;
                answer[x][y] = 0;   // 입력 불가시 0으로 초기화
            }
        }

        return false;
    }

    public static int[] findEmptyCell() {

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(answer[i][j] == 0 ) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}