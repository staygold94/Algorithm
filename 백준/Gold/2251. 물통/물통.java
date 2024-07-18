import java.io.*;
import java.util.*;

class AB {
    int a;
    int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static int[] arr;
    public static boolean[][] visited;
    public static boolean[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[3];   // 각 물통의 범위
        visited = new boolean[201][201];
        answer = new boolean[201];
        for(int i=0; i<3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        for(int i=0; i<answer.length; i++) {
            if(answer[i]) System.out.print(i + " ");
        }
    }

    public static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        int[] sender = {0, 0, 1, 1, 2, 2};
        int[] receiver = {1, 2, 0, 2, 0, 1};

        // 초기값 설정
        queue.offer(new AB(0, 0));
        visited[0][0] = true;
        answer[arr[2]] = true;

        while(!queue.isEmpty()) {
            AB o = queue.poll();
            int a = o.a;
            int b = o.b;
            int c = arr[2] - a - b;

            // 총 6가지 경우로 물을 옮겨줍니다
            for(int i=0; i<6; i++) {
                int[] next = {a, b, c};
                
                // 물을 옮겨줍니다
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                // 넘친 양에 대해서 다시 돌려줍니다
                if(next[receiver[i]] > arr[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - arr[receiver[i]];
                    next[receiver[i]] = arr[receiver[i]];
                }

                // 만약 새로운 물조합이라면 방문 처리하고 queue에 넣습니다.
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(new AB(next[0], next[1]));

                    // 이때 a가 빈값이라면 c의 값을 answer에 저장합니다.
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}