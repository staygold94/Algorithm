import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;

        // 배열 선언
        arr = new int[test[0]+1][test[0]+1];
        visited = new boolean[test[0]+1];

        // 간선 갯수만큼 배열 값 넣기
        for(int i=0; i<test[1]; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[tmp[0]][tmp[1]] = 1;
            arr[tmp[1]][tmp[0]] = 1;
        }

        // 반복문 실행
        for(int i=1; i<=test[0]; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        // 정답 출력
        System.out.println(answer);
    }

    public static void dfs(int idx) {

        // 방문처리
        visited[idx] = true;

        for(int i=0; i<arr[idx].length; i++) {
            if(!visited[i] && arr[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}
