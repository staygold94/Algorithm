import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());            // 도시 개수
        int[] distances = new int[n-1];                     // 도시 간 거리
        int[] costs = new int[n];                           // 도시별 기름 가격

        // 입력 받기
        distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long total = 0L;    // 총금액
        int min = costs[0];     // 현재 위치

        for(int i=0; i<n-1; i++) {
            // 다음 도시까지 충전
            total += (long)distances[i] * min;

            if(costs[i+1] < min) {
                min = costs[i+1];
            }
        }
        System.out.println(total);
    }
}