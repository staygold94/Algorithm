import java.util.*;
import java.io.*;

public class Main {
    public static boolean[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chess = new boolean[n][m];

        // 흰색 true, 검정색 false
        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j=0; j<m; j++) {
                chess[i][j] = tmp[j].equals("W") ? true : false;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i+7<n; i++) {
            for(int j=0; j+7<m; j++) {
                answer = Math.min(answer, makeChess(i, j));
            }
        }

        System.out.println(answer);
    }
    
    public static int makeChess(int x, int y) {

        int result = Integer.MAX_VALUE;
        int whiteBlack = 0;
        int blackWhite = 0;

        for(int i=x; i<x+8; i++) {
            for(int j=y; j<y+8; j++) {
                // 시작점
                if((i+j) % 2 == 0) {
                    // 화이트라면
                    if(chess[i][j]) {
                        blackWhite++;
                    } else {
                        whiteBlack++;
                    }
                } else {
                    // 화이트라면
                    if(chess[i][j]) {
                        whiteBlack++;
                    } else {
                        blackWhite++;
                    }
                }
            }
        }

        result = Math.min(result, whiteBlack);
        result = Math.min(result, blackWhite);

        return result;
    }
}