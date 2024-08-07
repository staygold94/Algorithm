import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
    public static List<Node>[] arr;
    public static boolean[] visited;
    public static int maxIdx, maxWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new List[n+1];
        visited = new boolean[n+1];

        // 초기화
        for(int i=0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   // 부모
            int c = Integer.parseInt(st.nextToken());   // 자식
            int w = Integer.parseInt(st.nextToken());   // 가��치

            arr[p].add(new Node(c, w));
            arr[c].add(new Node(p, w));
        }

        // 임의의 점에서 가장 긴 점 찾기
        dfs(1, 0);

        // 가장 긴 점에서 가장 먼 점 찾고, 가중치 출력
        dfs(maxIdx, 0);
        System.out.println(maxWeight);
    }

    public static void dfs(int idx, int weight) {

        visited[idx] = true;

        if(maxWeight < weight) {
            maxWeight = weight;
            maxIdx = idx;
        }

        for(Node node : arr[idx]) {
            if(!visited[node.idx]) {
                dfs(node.idx, weight + node.weight);
            }
        }

        visited[idx] = false;
    }
}