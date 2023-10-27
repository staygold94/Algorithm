import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        dp[1] = arr[1];
        if(n > 1) {     // 1만 입력했을 경우 놓치지 말기!
            dp[2] = arr[1] + arr[2];
        }

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]));
        }

        // dp 출력
        // for(int i=0; i<=n; i++) {
        //     System.out.print(dp[i] + " ");
        // }

        System.out.println(dp[n]);
    }
}


/*

예시
6
6
10
13
9
8
1

33

먼저 와인은 3잔 연속 먹을 수 없다.
따라서 현재 와인을 먹을 수 있는 경우는
1. 전 와인을 먹고 현재 와인을 먹거나,
2. 전전 와인을 먹고 현재 와인을 먹는 2가지 경우로 나눌 수 있다.
이 두가지 경우 중 더 큰 값(더 많이 와인을 마시는 양)을 dp 배열에 저장하며 최대로 마실 수 있는 와인의 양을 구하는 것이다.

dp [n]은 n번째 와인까지 따졌을 때 마실 수 있는 와인의 최대 양이될 것이고, 각 경우는 아래와 같이 나타낼 수 있다.
1. 전전전(n-3)까지의 최대 양 + 전(n-1) 번째 양 + 현재 양 = (dp [n-3] + arr [n-1] + arr [n])
2. 전전(n-2)까지의 최대 양 + 현재 양 = (dp [n-2] + arr [n])

문제의 예시 [6, 10, 13, 9, 8, 1]에서 최종 저장된 dp값을 살펴보면 [6, 16, 23, 28, 33, 32]와 같이 저장이 된다.
dp [6]에 저장되어야 하는 값은 32가 아니라 33이어야 한다.
하지만 1의 양을 가진 6번째 와인을 마셨기 때문에 32가 계산된 것이다.
즉, 이전까지 구한 dp값보다 현재 와인을 마심으로써 구한 dp값이 작다면 현재 와인을 마시지 말아야 한다.

따라서 기존 2가지 조건에 3. 전(n-1)까지의 최대양 + 현재 와인을 마시지 않는 경우도 추가해 같이 비교해주어야 한다.


- 1자리
6
o

- 2자리
6	10
o	o   16

- 3자리 dp[3]
6	10	13
o   x   o    19

x   o   o   23


- 4자리
6	10	13	9
o   x   o   o   28  dp[i-3] + arr[i-1] + arr[i]

o   o   x   o   25  dp[i-2] + arr[i]


-- 5자리
6	10	13	9	8
o   o   x   o   o   33



 */