import java.util.*;
import java.io.*;

public class Main {
    public static int r,c,k,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        answer = -1;
        int[][] firstArr = new int[3][3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                firstArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(firstArr, 0);

        System.out.println(answer);
    }

    public static void dfs(int[][] arr, int depth) {

        if(arr.length - 1 >= r && arr[0].length - 1 >= c) {
            if(arr[r][c] == k) {
                answer = depth;
                return;
            }
        }

        if(depth == 100) {
            return;
        }

        int newR = arr.length;
        int newC = arr[0].length;
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int[][] newBoard;

        // R 연산
        if(newR >= newC) {

            for(int i=0; i<newR; i++) {
                int[][] count = new int[101][2];
                for(int j=0; j<101; j++) {
                    Arrays.fill(count[i], 0);
                }
                for(int j=0; j<newC; j++) {
                    count[arr[i][j]][0] = arr[i][j];
                    count[arr[i][j]][1]++;
                }
                
                Arrays.sort(count, (o1, o2) -> {

                    if(o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                });

                int rowCnt = 0;
                
                for(int[] c : count) {
                    if(c[0] != 0 && c[1] > 0) {
                        sb.append(c[0] + " " + c[1] + " ");
                        rowCnt += 2;
                    }
                }
                sb.append("\n");
                max = Math.max(max, rowCnt);
            }

            newBoard = new int[newR][max > 100 ? 100 : max];

            String[] lines = sb.toString().split("\n");
            for(int i=0; i<newR; i++) {
                StringTokenizer st = new StringTokenizer(lines[i]);
                for(int j=0; j<newBoard[i].length; j++) {
                    newBoard[i][j] = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                }
            }

        // C 연산
        } else {

            for(int i=0; i<newC; i++) {
                int[][] count = new int[101][2];
                for(int j=0; j<101; j++) {
                    Arrays.fill(count[i], 0);
                }
                for(int j=0; j<newR; j++) {
                    count[arr[j][i]][0] = arr[j][i];
                    count[arr[j][i]][1]++;
                }
                
                Arrays.sort(count, (o1, o2) -> {

                    if(o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                });

                int rowCnt = 0;
                
                for(int[] c : count) {
                    if(c[0] != 0 && c[1] > 0) {
                        sb.append(c[0] + " " + c[1] + " ");
                        rowCnt += 2;
                    }
                }
                sb.append("\n");
                max = Math.max(max, rowCnt);
            }

            newBoard = new int[max > 100 ? 100 : max][newC];

            String[] lines = sb.toString().split("\n");
            for(int i=0; i<newC; i++) {
                StringTokenizer st = new StringTokenizer(lines[i]);
                for(int j=0; j<newBoard.length; j++) {
                    newBoard[j][i] = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                }
            }
        }

        dfs(newBoard, depth+1);        
    }
}