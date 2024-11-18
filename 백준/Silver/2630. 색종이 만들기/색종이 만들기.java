import java.util.*;
import java.io.*;

public class Main {
    public static boolean[][] arr;
    public static int white = 0, blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[i][j] = (tmp[j].equals("0") ? false : true);
            }
        }

        dfs(0, 0, n);
        System.out.println(white + " " + blue);
    }

    public static void dfs(int x, int y, int size) {

        // 사이즈가 1이거나 다같은 색인 경우
        if(size == 1 || isValid(x, y, size)) {
            if(arr[x][y] == false) white++;
            else blue++;
            return;
        } else {
            for(int i=x; i<x+size; i+=(size/2)) {
                for(int j=y; j<y+size; j+=(size/2)) {
                    dfs(i, j, size/2);
                }
            }
        }
    }

    public static boolean isValid(int x, int y, int size) {

        boolean color = arr[x][y];

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(color != arr[i][j]) return false;
            }
        }

        return true;
    }
}