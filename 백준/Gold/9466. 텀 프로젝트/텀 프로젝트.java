import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int[] visited;
    public static Stack<Integer> stack;
    public static List<Integer> cycleList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 테스트 케이스

        for(int i=0; i<T; i++) {

            int n = Integer.parseInt(br.readLine());    // 학생의 수
            arr = new int[n+1];                         // 희망자 배열
            visited = new int[n+1];                     // 방문자 배열 (0:미방문, 1:방문중, 2:방문완료)
            stack = new Stack<>();                      // 순회 순서 저장
            cycleList = new ArrayList<>();              // 사이클 리스트

            // 희망자 배열에 값 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            // 방문하지 않은 경우 dfs로 탐색
            for(int j=1; j<=n; j++) {
                if(visited[j] == 0) {
                    dfs(j);
                }
            }
            System.out.println(n-cycleList.size());
        }
    }

    public static void dfs(int idx) {
        // 방문중으로 처리, 스택에 순회순서 쌓기
        visited[idx] = 1;
        stack.push(idx);

        int nextIdx = arr[idx];

        // 다음 정점을 아직 미방문했다면
        if(visited[nextIdx] == 0) {
            dfs(nextIdx);
        
        // 방문중인 배열이라면 사이클 발견
        } else if(visited[nextIdx] == 1) {
            for(int i=stack.indexOf(nextIdx); i<stack.size(); i++) {
                cycleList.add(nextIdx);
            }
        }

        // 방문완료로 처리, 스택에서 제거
        visited[idx] = 2;
        stack.pop();
    }
}