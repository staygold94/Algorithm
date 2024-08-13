import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // 값 입력 받기
        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, n);
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y, int size) {

        boolean isValid = true;
        int num = arr[x][y];

        if(size == 1) {
            sb.append(num);
            return;
        }

        outerLoop:
        for(int i=x; i<size+x; i++) {
            for(int j=y; j<size+y; j++) {
                if(num != arr[i][j]) {
                    isValid = false;
                    break outerLoop;
                }
            }
        }

        if(!isValid) {
            int newSize = size / 2;
            sb.append("(");
            for(int i=0; i<2; i++) {
                for(int j=0; j<2; j++) {
                    dfs(x + newSize * i, y + newSize * j, newSize);
                }
            }
            sb.append(")");
        } else {
            sb.append(num);
        }
    }
}