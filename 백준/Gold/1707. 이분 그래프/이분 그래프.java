import java.io.*;
import java.util.*;

public class Main {
    public static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            // 정답 초기화
            answer = true;

            // 배열 생성
            int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<List<Integer>> list = new ArrayList<>();
            int[] colors = new int[test[0]+1];

            // colors 초기화
            for(int j=0; j<=test[0]; j++) {
                list.add(new ArrayList<>());
            } 

            // 연결된 간선 배열에 입력
            for(int j=0; j<test[1]; j++) {
                int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.get(tmp[0]).add(tmp[1]);
                list.get(tmp[1]).add(tmp[0]);
            }

            // dfs 호출
            for(int j=1; j<colors.length; j++) {
                if(colors[j] == 0) {
                    bfs(list, colors, j, 1);
                }
                if(!answer) break;
            }

            // 정답 출력
            System.out.println(answer == true ? "YES" : "NO");
        }
    }

    public static void bfs(List<List<Integer>> list, int[] colors, int idx, int color) {

        Queue<Integer> queue = new LinkedList<>();

        // 초기값 넣어주기
        queue.offer(idx);
        colors[idx] = color;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> tmp = list.get(num);
            if(tmp == null) return;
            for(int i : tmp) {

                if(colors[num] == colors[i]) {
                    answer = false;
                    return;
                }

                // 방문하지 않았다면
                if(colors[i] == 0) {
                    queue.offer(i);
                    colors[i] = colors[num] * -1;
                }
            }
        }       
    }
}