import java.io.*;
import java.util.*;

class Obj2 {
    String str;
    int cnt;

    public Obj2(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        for(int i=0; i<3; i++) {
            String s = br.readLine();
            s = s.replaceAll(" ", "");
            str += s;
        }
        
        int answer = bfs(str, 0);
        System.out.println(answer);
    }

    public static int bfs(String str, int cnt) {
        int result = -1;
        String target = "123456780";
        Queue<Obj2> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int[] moves = {-1, 1, -3, 3};

        // 초기값 넣기
        queue.offer(new Obj2(str, cnt));
        set.add(str);

        while(!queue.isEmpty()) {
            Obj2 o = queue.poll();

            // 정답 발견시 break
            if(target.equals(o.str)) {
                result = o.cnt;
                break;
            }

            StringBuilder sb;
            int idx = o.str.indexOf("0");

            for(int i=0; i<moves.length; i++) {
                // 0이 중간이 아닌 경우 -1, +1 할 수 없는 경우 존재!!!
                if((idx % 3 == 0 && i == 0) || (idx % 3 == 2 && i == 1)) continue;

                int nextIdx = idx + moves[i];
                
                // 변경 가능한 경우
                if(nextIdx >= 0 && nextIdx < 9) {
                    // 위치 이동
                    sb = new StringBuilder(o.str);
                    sb.setCharAt(idx, sb.charAt(nextIdx));
                    sb.setCharAt(nextIdx, '0');

                    // 나온 적 없는 경우 queue에 추가
                    String s = sb.toString();
                    if(!set.contains(s)) {
                        set.add(s);
                        queue.offer(new Obj2(s, o.cnt+1));
                    }
                }                
            }
        }
        return result;
    }
}