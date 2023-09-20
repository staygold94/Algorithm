import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // StringTokenizer를 이용하여 BufferedReader 값 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());    // 숫자 개수
        int quizNo = Integer.parseInt(st.nextToken());  // 질의 개수

        // 합 배열 (인덱스 0번째는 0으로 둘 예정)
        long[] S = new long[suNo + 1];

        // 배열 입력받음
        st = new StringTokenizer(br.readLine());

        /*  합 배열
         *  S[i] = S[i-1] + A[i] // 합 배열
         */
        for(int i=1; i<S.length; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        // 질의 개수만큼 반복문
        for(int i=0; i<quizNo; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 구간 합 구하는 법
            System.out.println(S[y] - S[x-1]);
        }

    }
    
}
