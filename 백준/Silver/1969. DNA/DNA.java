import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][4];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                int idx;
                switch(s.charAt(j)) {
                    case 'A':
                    idx = 0;
                    break;
                    case 'C':
                    idx = 1;
                    break;
                    case 'G':
                    idx = 2;
                    break;
                    default:
                    idx = 3;
                    break;
                }
                arr[j][idx]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int total = 0;
        for(int i=0; i<m; i++) {
            int maxIdx = 0;
            for(int j=1; j<4; j++) {
                if(arr[i][j] > arr[i][maxIdx]) maxIdx = j;
            }
            total += arr[i][maxIdx];
            switch(maxIdx) {
                case 0:
                sb.append("A");
                break;
                case 1:
                sb.append("C");
                break;
                case 2:
                sb.append("G");
                break;
                default:
                sb.append("T");
                break;
            }
        }
        System.out.println(sb.toString());
        System.out.println(n*m - total);
    }
}