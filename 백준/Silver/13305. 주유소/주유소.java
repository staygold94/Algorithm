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
        int nowIdx = 0;     // 현재 위치

        while(nowIdx < n-1) {

            // 다음 도시까지 충전
            total += (distances[nowIdx] * costs[nowIdx]);

            // 마지막 도시 전까지 다음 도시가 더 비싼 경우 지금 충전
            int nextIdx = nowIdx+1;
            while(nextIdx < n-1 &&  costs[nextIdx] > costs[nowIdx]) {
                total += (distances[nextIdx] * costs[nowIdx]);
                nextIdx++;
            }
            nowIdx = nextIdx;
        }
        System.out.println(total);
    }
}