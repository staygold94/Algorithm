import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new List[n+1];

        // 배열 초기화
        for(int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 노드 관계 입력 받기
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 양쪽에 연결하기
            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        // 부모 노드를 기입할 배열
        int[] parents = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();

        // 초기값 루트 1 넣기
        queue.offer(1);
        parents[1] = -1;    // 방문처리

        while(!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> tmp = arr[num];

            for(int i : tmp) {
                if(parents[i] == 0) {
                    parents[i] = num;
                    queue.offer(i);
                }
            }
        }

        for(int i=2; i<=n; i++) {
            System.out.println(parents[i]);
        }
    }
}