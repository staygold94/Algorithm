import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = 0;
        int books = m;
        int answer = 0;

        // 마이너스 좌표
        for(int i=0; i<n && arr[i]<0; i++) {
            // 첫 방문이라면
            if(books == m) {
                max = Math.max(max, Math.abs(arr[i]));
                answer += Math.abs(arr[i]) * 2;
            }

            // 책 꽂기
            books--;

            // 책 다 꽂았다면
            if(books == 0) books = m;
        }

        // 옮길 수 있는 책 리셋
        books = m;

        // 플러스 좌표
        for(int i=n-1; i>=0 && arr[i]>0; i--) {
            // 첫 방문이라면
            if(books == m) {
                max = Math.max(max, Math.abs(arr[i]));
                answer += Math.abs(arr[i]) * 2;
            }

            // 책 꽂기
            books--;

            // 책 다 꽂았다면
            if(books == 0) books = m;
        }

        // 가장 먼 방문을 마지막으로 돌아갈 필요 없음
        answer -= max;
        System.out.print(answer);
    }
}