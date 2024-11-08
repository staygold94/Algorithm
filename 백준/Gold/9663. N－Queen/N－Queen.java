import java.io.*;

public class Main {
    public static int n, answer;
    public static boolean[] v1, v2, v3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        v1 = new boolean[n];
        v2 = new boolean[2*n - 1];
        v3 = new boolean[2*n - 1];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            // v1은 가로세로
            // v2는 왼쪽 아래에서 오른쪽 위로 이동하는 대각선
            // v3은 왼쪽 위에서 오른쪽 아래로 이동하는 대각선

            // num은 v3에 들어갈 숫자로
            // depth - i가 -(n-1) ~ (n-1) 범위이기에 (n-1)를 더해서 인덱스 범위로 만들어준다.
            int num = depth - i + (n-1);
            if(!v1[i] && !v2[depth+i] && !v3[num]) {
                v1[i] = true;
                v2[depth+i] = true;
                v3[num] = true;

                dfs(depth+1);
                
                v1[i] = false;
                v2[depth+i] = false;
                v3[num] = false;
            }
        }
    }
} 