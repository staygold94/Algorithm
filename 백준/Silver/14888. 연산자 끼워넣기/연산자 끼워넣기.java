import java.util.*;
import java.io.*;

public class Main {
    public static int n, max, min;
    public static int[] arr;
    public static int[] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int total) {

        if(depth == n) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for(int i=0; i<4; i++) {
            if(op[i] > 0) {
                op[i]--;
                int num = total;
                switch (i) {
                    case 0:
                        num += arr[depth];
                        break;
                    case 1:
                        num -= arr[depth];
                        break;
                    case 2:
                        num *= arr[depth];
                        break;
                    case 3:
                        if(num < 0) num = -(-num / arr[depth]);
                        else num /= arr[depth];
                        break;
                }
                dfs(depth + 1, num);
                op[i]++;
            }
        }
    }
}