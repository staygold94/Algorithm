import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // dp 배열 생성
        Integer[] dp = new Integer[n+1];

        // 초기화 값 설정
        dp[0] = 0;

        // 재귀의 깊이가 쌓이지 않기 위해서 낮은 수부터 반복문
        for(int i=1; i<=n; i++) {
            // 1^ + 1 ^ ... + 1^ 처럼 최대개수를 기본값으로 지정
            dp[i] = i; 

            // 제곱근까지 반복문 (=> 최소개수 조합을 찾기 위함)
            for(int j=2; j*j <= i; j++) {
                // 기본값과 다른 제곱근의 조합 중 최소개수를 dp의 값으로 지정 
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }

        System.out.println(dp[n]);
    } 
}


/*

11 3

82009 : 2

89005 : 3

61495 : 4

2542 : 3

77882 : 3

10198 : 3

37961 : 3

98952 : 3

35057 : 3

 */