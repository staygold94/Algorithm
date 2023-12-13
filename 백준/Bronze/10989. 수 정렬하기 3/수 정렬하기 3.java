import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];  // 수의 범위

        // 계수 정렬 (Counting Sort)
        for(int i=0 ; i<n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        
        br.close();

        // !! StringBuilder를 쓰지 않아 시간초과가 종종 나고 있다. 주의 !!
        StringBuilder sb = new StringBuilder();

        // 누적합 생략하고 바로 arr[i] 갯수만큼 출력
        for(int i=1 ; i<10001; i++) {
            while(arr[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}

/*
 * 참고하면 좋은 사이트
 * https://st-lab.tistory.com/104
 */