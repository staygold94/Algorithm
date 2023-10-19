import java.io.*;

public class Main {

    static Long[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Long[n+1][10];

        // 1자릿수, 2자릿수 초기화
        for(int i=0; i<10; i++) {
            dp[0][i] = 1L;
            dp[1][i] = 10L-i;
        }

        // 3번째 자릿수부터 n개까지 solve 함수 실행
        for(int i=2; i<n; i++) {
            for(int j=0; j<10; j++) {
                solve(i,j);
            }
        }

        // dp 프린트
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<10; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        Long answer = 0L;

        // n의 자릿수
        for(int i=0; i<10; i++) {
            answer += dp[n-1][i];
        }

        System.out.println(answer % 10007);
    }

    static Long solve(int i, int j) {

        Long sum = 0L;    // dp[i-2][0]번째부터 dp[i-2][j-1]번째까지의 합

        for(int z=j; z<10; z++) {
            sum += dp[i-1][z];
        }

        dp[i][j] = (sum % 10007);

        return dp[i][j];
    }
}


/*
 
// 0~9 숫자가 맨앞자리라고 했을 때
// 0~9까지의 각 숫자(i)를 만들 수 있는 오르막 수는
// 이전 자릿수 n-1에서의 j부터 마지막 마지막 9까지의 합

    1   2   3   4
0   1   10  55  220
1   1   9   45  
2   1   8   36 
3   1   7   28 
4   1   6   21  
5   1   5   15  
6   1   4   10  
7   1   3   6  
8   1   2   3  
9   1   1   1

 */


 /* 테스트 케이스
  
1
10

2
55

3
220

4
715

5
2002

6
5005

7
1433

8
4296

9
8592

10
2315

11
7848

12
3727

13
7077

18
3549

100
3831

1000
1464

500
8045

499
6153


  */