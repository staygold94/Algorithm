import java.io.*;
import java.util.*;

class Obj {
    int num;
    String str;
    
    public Obj(int num, String str) {
        this.num = num;
        this.str = str;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String answer = bfs(a, b);
            System.out.println(answer);
        }
    }

    public static String bfs(int a, int b) {
        String result = "";
        Queue<Obj> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        // 초기값 설정
        queue.offer(new Obj(a, ""));
        visited[a] = true;

        while(!queue.isEmpty()) {
            Obj o = queue.poll();

            // 원하는 숫자라면 정답 갱신 및 break
            if(o.num == b) {
                result  = o.str;
                break;
            }

            // D
            int d = (2*o.num) % 10000;
            if(!visited[d]) {
                queue.offer(new Obj(d, o.str + "D"));
                visited[d] = true;
            }
            
            // S
            int s = o.num == 0 ? 9999 : o.num - 1;
            if(!visited[s]) {
                queue.offer(new Obj(s, o.str + "S"));
                visited[s] = true;
            }
            
            // L
            int l = o.num % 1000 * 10 + o.num / 1000;
            if(!visited[l]) {
                queue.offer(new Obj(l, o.str + "L"));
                visited[l] = true;
            }
            
            // R
            int r = o.num % 10 * 1000 + o.num / 10;
            if(!visited[r]) {
                queue.offer(new Obj(r, o.str + "R"));
                visited[r] = true;
            }

        }
        return result;
    }
}