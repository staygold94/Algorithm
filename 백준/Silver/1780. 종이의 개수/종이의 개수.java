import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer = new int[3];

        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, n);
        for(int i : answer) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y, int dist) {

        int num = arr[x][y];
        boolean isValid = true;
        
        outerLoop:
        for(int i=x; i<x+dist; i++) {
            for(int j=y; j<y+dist; j++) {
                if(num != arr[i][j]) {
                    isValid = false;
                    break outerLoop;
                }
            }
        }

        if(isValid) {
            switch (num) {
                case -1 :
                    answer[0]++;
                    break;
                case 0 :
                    answer[1]++;
                    break;
                case 1 :
                    answer[2]++;
                    break;
            }
            return;
        } else {
            int newDist = dist/3;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    dfs(x + newDist * i, y + newDist * j, dist/3);
                }
            }
        }
    }
}