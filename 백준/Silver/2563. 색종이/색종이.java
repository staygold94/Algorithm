import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] black = new boolean[100][100];
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    if(!black[j][k]) {
                        black[j][k] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}