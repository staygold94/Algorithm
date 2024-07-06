import java.io.*;
import java.util.*;

public class Main {
    public HashMap<Integer, List<Integer>> map;
    public String answer;
    public boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        Main sol = new Main();
        sol.solution();
    }

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] T = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new HashMap<>();

        // 간선 개수만큼 map에 저장
        for(int i=0; i<T[1]; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.putIfAbsent(arr[0], new ArrayList<>());
            map.putIfAbsent(arr[1], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        // dfs 호출
        answer = "";
        visited = new boolean[T[0]+1];
        dfs(visited, T[2]);
        System.out.println(answer);

        // bfs 호출
        answer = "";
        visited = new boolean[T[0]+1];
        bfs(visited, T[2]);
        System.out.println(answer);
    }

    public void dfs(boolean[] visited, int idx) {

        // 방문처리
        visited[idx] = true;
        answer += String.valueOf(idx) + " ";

        List<Integer> list = map.get(idx);
        if(list != null) {
            Collections.sort(list);

            for(int i : list) {
                if(!visited[i]) {
                    dfs(visited, i);
                }
            }
        }
    }

    public void bfs(boolean[] visited, int idx) {

        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.offer(idx);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            answer += String.valueOf(num) + " ";
            
            List<Integer> list = map.get(num);
            if(list != null) {
                Collections.sort(list);

                for(int i : list) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
