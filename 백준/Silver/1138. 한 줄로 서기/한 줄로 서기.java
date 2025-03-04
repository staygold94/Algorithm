import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            int cnt = 0;
            int num = Integer.parseInt(st.nextToken());
            
            for(int j=0; j<n; j++) {
                // 이미 채워진 칸은 패스
                if(arr[j] != 0) {
                    continue;

                // 큰 사랑 num명을 지나친 뒤
                } else if(cnt == num) {
                    arr[j] = i;
                    break;

                // 아직 큰 사람 num명을 지나치지 않았다면 지나치기
                } else {
                    cnt++;
                }
            }
        }

        for(int num : arr) {
            System.out.print(num + " ");
        }        
    }
}