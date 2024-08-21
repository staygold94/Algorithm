import java.io.*;
import java.util.*;

public class Main {
    public static int L, C;
    public static String[] arr;
    public static boolean[] visited;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        visited = new boolean[C];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken();
        }

        // 정렬
        Arrays.sort(arr);

        dfs("", 0, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(String str, int idx, int depth) {

        if(depth == L) {
            int mo = 0;
            int ja = 0;

            for(char c : str.toCharArray()) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    mo++;
                } else {
                    ja++;
                }
            }
            // 모음이 1개, 자음이 2개 포함되어 있어야 함
            if(mo >= 1 && ja >= 2) {
                sb.append(str + "\n");
            }
            return;
        }

        for(int i=0; i<C; i++) {
            // 이전 순서인 경우 패스
            if(i < idx) continue;

            // 더 탐색할 필요 없는 경우
            if(depth + (C - i)  < L) {
                return;
            }

            if(!visited[i]) {
                visited[i] = true;
                dfs(str+arr[i], i, depth+1);
                visited[i] = false;
            }
        }
    }
}