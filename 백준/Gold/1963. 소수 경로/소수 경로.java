import java.io.*;
import java.util.*;

class Prime {
    String num;
    int cnt;

    public Prime(String num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            int cnt = bfs(start, end);
            System.out.println(cnt == -1 ? "Impossible" : cnt);
        }
    }

    public static int bfs(String start, String end) {
        int cnt = -1;
        HashSet<String> set = new HashSet<>();
        Queue<Prime> queue = new LinkedList<>();
        queue.offer(new Prime(start, 0));
        set.add(start);

        while(!queue.isEmpty()) {
            Prime p = queue.poll();

            // 동일한 숫자 만든 경우
            if(end.equals(p.num)) {
                cnt = p.cnt;
                break;
            }

            for(int i=0; i<4; i++) {
                for(int j=0; j<=9; j++) {
                    if(i == 0 && j == 0) continue;

                    StringBuilder sb = new StringBuilder(p.num);
                    sb.setCharAt(i, (char)(j + '0'));
                    String num = sb.toString();

                    // 소수이면서 아직 만들지 않은 경우
                    if(isPrime(Integer.parseInt(num)) && !set.contains(num)) {
                        queue.offer(new Prime(num, p.cnt+1));
                        set.add(num);
                    }
                }
            }
        }

        return cnt;
    }

    public static boolean isPrime(int n) {

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}