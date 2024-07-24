import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] costs, dp;
    // 최악의 경우 : 도시의 수가 16인 경우. 최대 경로 비용은 15 * 1,000,000입니다 (시작 도시로 돌아오는 비용 포함하면 16 * 1,000,000)
    public static int INF = 16_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 비용 배열 및 dp 배열 초기화
        costs = new int[n][n];
        dp = new int[n][(1<<n)];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        // 비용 입력 받기
        for(int i=0; i<n; i++) {
            costs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 시작점이 달라도 전체최소비용은 동일함 (사이클을 가지기 때문)
        int answer = dfs(0, 1);
        System.out.println(answer);
    }

    public static int dfs(int now, int visit) {

        // 전체 다 방문한 경우
        if(visit == (1<<n) - 1) {
            // 시작점으로 돌아갈 길이 있다면 정답 갱신
            if(costs[now][0] != 0) {
                return costs[now][0];
            } else {
                return INF;
            }
        }

        // 이미 계산된 경우
        if(dp[now][visit] != -1) {
            return dp[now][visit];
        }
        dp[now][visit] = INF;

        // 방문하지 않은 도시 방문
        for(int i=0; i<n; i++) {
            // 방문하지 않았고, 방문이 가능한 경우
            if((visit & (1<<i)) == 0 && costs[now][i] != 0) {
                dp[now][visit] = Math.min(dp[now][visit],  dfs(i, visit | (1 << i)) + costs[now][i]);
            }
        }
        return dp[now][visit];
    }
}

/*
 * 1<<n : 1을 왼쪽으로 n번 비트 시프트한다는 의미입니다. 이를 통해 2의 n제곱 값을 얻을 수 있습니다
 * (1<<i)-1 : 1을 왼쪽으로 i번 비트 시프트한 값에서 1을 뺀다는 의미입니다. 이를 통해 i개의 하위 비트가 모두 1인 값을 얻을 수 있습니다
 */