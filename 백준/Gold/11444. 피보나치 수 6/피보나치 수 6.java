import java.io.*;

public class Main {
    public static long[][] arr = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] result = dfs(n-1);
        System.out.println(result[0][0]);   // f(n) = f(n-1) + f(n-2) 이지만 초기값 {1,0} 곱할 것이므로 f(n-1)만 출력하면 됨
    }

    public static long[][] dfs(long cnt) {

        long[][] result = {{1, 0}, {0, 1}};  // 행렬의 항등원
        long[][] base = arr;

        // 재귀로 내려가면 깊이가 깊어질 수 있어 (top-bottom)
        // 가장 낮은 단위부터 제곱해가려고 함(bottom-top)
        while(cnt > 0) {
            
            // 무조건 1에 도달하게 되어있음
            // 나머지가 1일 때 홀수이므로 base를 한 번 더 곱해주기도 해야함
            if(cnt % 2 == 1) result = multi(result, base);
            base = multi(base, base);

            cnt /= 2;
        }
        return result;
    }

    public static long[][] multi(long[][] arr1, long[][] arr2) {

        int a = arr1.length;
        int b = arr2.length;
        int c = arr2[0].length;
        long[][] result = new long[a][c];

        for(int i=0; i<a; i++) {
            for(int j=0; j<c; j++) {
                for(int k=0; k<b; k++) {
                    long tmp = (result[i][j] + arr1[i][k] * arr2[k][j]) % 1_000_000_007;
                    result[i][j] = tmp;
                }
            }
        }
        return result;
    }
}