import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] blackChess = new int[n+1][m+1];
        int[][] WhiteChess = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j=1; j<=m; j++) {
                boolean isWhite = tmp[j-1].equals("W") ? true : false;
                blackChess[i][j] = blackChess[i][j-1] + blackChess[i-1][j] - blackChess[i-1][j-1];
                WhiteChess[i][j] = WhiteChess[i][j-1] + WhiteChess[i-1][j] - WhiteChess[i-1][j-1];
                // 시작점
                if((i+j) % 2 == 0) {
                    if(isWhite) {
                        blackChess[i][j]++;
                    } else {
                        WhiteChess[i][j]++;
                    }
                } else {
                    if(isWhite) {
                        WhiteChess[i][j]++;
                    } else {
                        blackChess[i][j]++;
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1; i+k-1 <=n; i++) {
            for(int j=1; j+k-1 <=m; j++) {
                answer = Math.min(answer, blackChess[i+k-1][j+k-1] - blackChess[i-1][j+k-1] - blackChess[i+k-1][j-1] + blackChess[i-1][j-1]);
                answer = Math.min(answer, WhiteChess[i+k-1][j+k-1] - WhiteChess[i-1][j+k-1] - WhiteChess[i+k-1][j-1] + WhiteChess[i-1][j-1]);
            }
        }
        System.out.println(answer);
    }
}