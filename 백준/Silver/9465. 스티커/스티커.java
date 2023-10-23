import java.io.*;

public class Main {
    static Long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {

            int num = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][num+1];         // dp 배열
            int[][] stickers = new int[2][num+1];   // 입력받을 값

            // 입력받은 값 int 배열에 넣음
            for(int j=0; j<2; j++) {
                String[] arr = br.readLine().split(" ");

                for(int k=1; k<=num; k++) {
                    stickers[j][k] = Integer.parseInt(arr[k-1]);
                }
            }
            
            // stickers 배열 프린트
            // for(int j=0; j<2; j++) {
            //     for(int k=0; k<=num; k++) {
            //         System.out.print(stickers[j][k] + " ");
            //     }
            //     System.out.println();
            // }

            /*
             * 해당 문제를 dp의 개념으로 생각한다면,
             * 왼쪽 대각선 아래, 왼쪽 대각선 아래의 왼쪽만 확인해서 더 큰 값을 현재 위치에 넣어주면 된다.
             */

            // 초기화
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int j=2; j<=num; j++) {
                dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + stickers[1][j];
            }

            // dp 배열 프린트
            // for(int j=0; j<2; j++) {
            //     for(int k=0; k<=num; k++) {
            //         System.out.print(dp[j][k] + " ");
            //     }
            //     System.out.println();
            // }

            // 큰 값을 더해서 dp 배열을 쌓아왔으므로, 마지막 열에서 큰 값만 출력하면 된다.
            System.out.println(Math.max(dp[0][num], dp[1][num]));
        }
    }
}

/*
몇 가지 경우를 살펴보자!
1. (0,1) 위치의 스티커를 뗀다면 인접한 (0,2)과 (1,1)은 사용할 수 없게 된다.
    1   2   3   4   5
0   o   x   o   o   o
1   x   o   o   o   o

2. (1,1) 위치의 스티커를 뗀다면 인접한 2개의 스티커는 사용할 수 없게 된다.
    1   2   3   4   5
0   x   o   o   o   o
1   o   x   o   o   o

3. (1,2) 위치의 스티커를 뗀다면 인접한 3개의 스티커는 사용할 수 없게 된다.
이 경우 1번과 2번 세로줄까지만 생각했을 때, 가장 스티커 합이 많아지는 경우는 (0,1)을 뗀 후 (1,2)을 떼는 경우다.
    1   2   3   4   5
0   o   x   o   o   o
1   x   o   x   o   o

4. (0,3) 위치의 스티커를 떼어낸다면 경우의 수는 아래 2가지가 가능하다.
    1   2   3   4   5
0   o   x   o   x   o
1   x   o   x   o   o

    1   2   3   4   5
0   x   x   o   x   o
1   o   x   x   o   o

이 개념을 DP로 생각한다면 왼쪽 대각선 아래,
왼쪽 대각선 아래의 왼쪽만 확인해서 더 큰 값을 현재 위치에 넣어주면 된다! 4번 경우를 DP로 생각한다면, 이미 dp[1][2]에 (0,1)과 (1,2)의 합이 들어있기 때문에 dp[1][2]와 dp[1][1] 중에 큰 값과 (0,3)값을 더해 dp[0][3]에 저장하면 된다.
이런 식으로 5번 column까지 간 후, 더 큰 값이 결과값이 된다!


예제
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80

260
290
 */